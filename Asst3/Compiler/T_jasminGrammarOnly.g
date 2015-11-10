grammar T;


options {
language=Java;
}


@header {
import java.*;
import java.io.*;
}

@members {
final int t_INT = 0;
int variableCount = 0;
int labelCount = 0;
java.util.Map variableIndices = new java.util.HashMap<String, Integer>();
java.util.List<String> instList = new java.util.ArrayList<String>();
PrintWriter output = null;
}

//prog : 	stat+ ;
prog
	@init {
	try {
		output = new PrintWriter(new File("MyClass.j"));
	} catch(FileNotFoundException e) {
	}
	output.print(	  ".class MyClass\r\n"
			+ ".super java/lang/Object\r\n"
			+ ".method public <init>()V\r\n"
			+ "\taload_0\r\n"
			+ "\tinvokenonvirtual java/lang/Object/<init>()V\r\n"
			+ "\treturn\r\n"
			+ ".end method\r\n"
			+ ".method public static main([Ljava/lang/String;)V\r\n"
			+ ".limit stack 20\r\n");
	}



	@after {
	output.println(".limit locals " + variableCount);
	//print all instructions
	for(int i=0; i < instList.size(); i++)
	{
		String inst = instList.get(i);
		if(inst.startsWith("Label"))
			output.println(inst);
		else
			output.println("\t" + inst);
	}
	output.println("\treturn");
	output.println(".end method");
	output.close();
	}
:
stat+
;



stat	:	assignment ';'
	|	action ';'
	|	ifStatement
	|	whileStatement
	;

block  :	'{' stat+ '}'
	;


action : 'print' expression
	;

assignment : ID  '=' expression
	;

booleanExpr : expression ('=='|'!='|'<'|'>'|'<='|'>=') expression
	;

expression : multExpr (('+'|'-') multExpr)* ;

multExpr : atom (('*'|'/') atom)* 
	;

atom : ('-')? unsignedAtom
	;

unsignedAtom : INT | ID | '(' expression ')' 	
	;

whileStatement : 'while' '(' booleanExpr ')' block
	;

//ifStatement: 'if' '(' booleanExpr ')' block ('else' block)? ;
ifStatement
	@init
	{
	String elseLabel = "Label" + labelCount++;
	String afterElseLabel = "Label" + labelCount++;
	}
	: 'if' '(' booleanExpr ')'	
		{				
		String op = $booleanExpr.op;
		if(op.equals("==")) 
			instList.add("if_icmpne " + elseLabel);
		else if(op.equals("!=")) 
			instList.add("if_icmpeq " + elseLabel);
		else if(op.equals("<")) 
			instList.add("if_icmpge " + elseLabel);
		else if(op.equals(">")) 
			instList.add("if_icmple " + elseLabel);
		else if(op.equals("<=")) 
			instList.add("if_icmpgt " + elseLabel);
		else if(op.equals(">=")) 
			instList.add("if_icmplt " + elseLabel);
		}
	block (el='else'
		{
		instList.add("goto " + afterElseLabel);
		instList.add(elseLabel + ":");
		} 
	block)?	
	{
	//if there's an else
	if($el!=null)
		instList.add(afterElseLabel + ":");
	else
		instList.add(elseLabel + ":");		
	}
	;



ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	('0'..'9')+
    ;

WS 	:   (' '|'\t'|'\n'|'\r')+ {skip();} ;