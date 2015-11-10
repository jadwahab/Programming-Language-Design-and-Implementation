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


//action : 'print' expression;
action : 'print' 
		{instList.add("\tgetstatic java/lang/System/out Ljava/io/PrintStream;");}
	expression
		{instList.add("\tinvokevirtual java/io/PrintStream/println(I)V");}
	;

//assignment : ID  '=' expression;
assignment : ID  '=' expression
	{
		Integer index = (Integer)variableIndices.get($ID.text);
		if (index == null) {
			index = new Integer(variableCount++);
			variableIndices.put($ID.text, index);
		}
		instList.add("\tistore " + index.intValue());
	}
	;

//booleanExpr : expression ('=='|'!='|'<'|'>'|'<='|'>=') expression;
booleanExpr returns [String op]: expression oper=('=='|'!='|'<'|'>'|'<='|'>=') expression
	{$op = $oper.text;}
	;	

//expression : multExpr (('+'|'-') multExpr)* ;
expression : multExpr (op=('+'  | '-' ) multExpr   
		{ 
		   if ($op.text.equals("+")) 
			instList.add("\tiadd ");
		   else  if ($op.text.equals("-")) 
			instList.add("\tisub ");
		} 
				)* 
	;

//multExpr : atom (('*'|'/') atom)* ;
multExpr :	atom (op=('*'|'/') atom
		{ 
		   if ($op.text.equals("*")) 
			instList.add("\timul ");
		   else  if ($op.text.equals("/")) 
			instList.add("\tidiv ");
		} 
				)* 
	;

//atom : ('-')? unsignedAtom;
atom : (s='-')? unsignedAtom	
		{
		    if ($s != null)
		   	instList.add("\tineg ");
		}
	;

//unsignedAtom : INT | ID | '(' expression ')' 	;
unsignedAtom : 		INT 
		{ 	
			instList.add("\tldc " + $INT.text);
		}
	|	ID 
		{
			Integer index = (Integer)variableIndices.get($ID.text);
			if (index == null) {
				System.out.println("Undefined Variable = " + $ID.text);
			}
			instList.add("\tiload " + index.intValue());
		}
	|	'(' expression ')'
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

//whileStatement : 'while' '(' booleanExpr ')' block;
whileStatement
	@init
	{
	String beforeLabel = "Label" + labelCount++;
	String afterLabel = "Label" + labelCount++;
	instList.add(beforeLabel + ":");
	}
		
	: 'while' '(' booleanExpr ')'	
		{				
		String op = $booleanExpr.op;
		if(op.equals("==")) 
			instList.add("if_icmpne " + afterLabel);
		else if(op.equals("!=")) 
			instList.add("if_icmpeq " + afterLabel);
		else if(op.equals("<")) 
			instList.add("if_icmpge " + afterLabel);
		else if(op.equals(">")) 
			instList.add("if_icmple " + afterLabel);
		else if(op.equals("<=")) 
			instList.add("if_icmpgt " + afterLabel);
		else if(op.equals(">=")) 
			instList.add("if_icmplt " + afterLabel);
		}
	 block 
		{
		instList.add("goto " + beforeLabel);
		instList.add(afterLabel + ":");
		} 
	;


ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	('0'..'9')+
    ;

WS 	:   (' '|'\t'|'\n'|'\r')+ {skip();} ;