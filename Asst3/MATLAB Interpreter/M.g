grammar M;

options {
	backtrack = true;
}

@header {
	import java.*;
	import java.util.HashMap;
	import java.util.Vector;
}

@members{

HashMap variables = new HashMap();
Vector<MathObject> param = new Vector<MathObject>();


MathObject getVariable(String name) {
	if (variables.containsKey(name))
		return ((MathObject) variables.get(name));
	else 
		return null;								//RETURN NULL
}

void setVariable(String name, MathObject val) {
	variables.put(name,val);
}




}//end @members



prog 
	: 	stat+ 		
	EOF
	;

	
stat 												
	: 	//(assignment(';' NEWLINE?|NEWLINE) | function (';' NEWLINE?|NEWLINE) | expression (';' NEWLINE?|NEWLINE) )
		
		(assignment									
			(';' NEWLINE?
			|NEWLINE				{System.out.println($assignment.iden + " =\n" + $assignment.value);}	
			)						
		| function 
			(';' NEWLINE?
			|NEWLINE				{System.out.println("Ans =\n" + $function.value);}	
			)
		| expression								
			(';' NEWLINE?
			|NEWLINE				{System.out.println("Ans =\n" + $expression.value);}	
			)
		)
	;
	
	
assignment returns [MathObject value, String iden]
	: 	//ID '=' (seq | matrix | expression)
		ID 							{$iden = $ID.text;}
		'=' 						
		(seq 						{setVariable($ID.text, $seq.value); $value = $seq.value;}
		| matrix					{setVariable($ID.text, $matrix.value); $value = $matrix.value;}
		| expression				{setVariable($ID.text, $expression.value); $value = $expression.value;}
		) 
	;
	
	
matrix returns [MathObject value] 
	:	//'[' INT INT ';' INT INT ']'			//ONLY FOR THIS CASE
		'[' i0=INT i1=INT ';'
			i2=INT i3=INT ']'		{int a0 = Integer.parseInt($i0.text);
									 int a1 = Integer.parseInt($i1.text);
									 int a2 = Integer.parseInt($i2.text);
									 int a3 = Integer.parseInt($i3.text);
									 double [][] m = new double[2][2];
									 m[0][0]=a0;m[0][1]=a1;m[1][0]=a2;m[1][1]=a3;
									 $value = new MathMatrix(m);
									}
	;
	
/*									//without function call
seq returns [MathObject value]
	: 	//INT ':' INT
		int1=INT ':' int2=INT		
									{int a1 = Integer.parseInt($int1.text);	
									 int a2 = Integer.parseInt($int2.text);
									 double [][] m = new double[1][a2-a1+1];
									 for (int i=0; i<=(a2-a1); i++)
										m[0][i] = a1+i;
									 $value = new MathMatrix(m);	
									}
	;
*/

seq returns [MathObject value]
	: 	//fact ':' fact
		f1=fact ':' f2=fact		
									{$value =  MathOp.createSequence($f1.value, $f2.value);}
	;
	
	
expression returns [MathObject value]
	: 	//term ('+' term | '-' term)*
		t=term 						{$value = $t.value;}
		('+' t1=term 				{	try {
											$value = MathOp.add($value, $t1.value);
										}catch (MathException e) {
											System.out.println("Wrong dimensions");
										} catch (Exception e) {
											System.out.println("Wrong parameters");
										}
									}
		|'-' t1=term				{	try {
											$value = MathOp.add($value, MathOp.u_minus($t1.value));
										}catch (MathException e) {
											System.out.println("Wrong dimensions");
										} catch (Exception e) {
											System.out.println("Wrong parameters");
										}
									}
		)*		
		
	;

term returns [MathObject value]
	: 	//fact ('*' fact |'/' fact)*
		f=fact	 					{$value = $f.value;}
		('*' f1=fact				{	try {
											$value = MathOp.multiply($value, $f1.value);
										}catch (MathException e) {
											System.out.println("Wrong dimensions");
										} catch (Exception e) {
											System.out.println("Wrong parameters");
										}
									}
		//|'/' f1=fact				{$value /= $f1.value;} //(no implementation of division)
		)*
	
	;
	
fact returns [MathObject value]
	: 	//INT | ID | '(' expression ')'
		(minus='-'?) INT		{if (minus == null)
									$value = new MathScalar(Double.parseDouble($INT.text));
								 else
									$value = new MathScalar(-1*Double.parseDouble($INT.text));
								}
	| 	(minus='-'?) ID 		{if (minus == null)
									$value = getVariable($ID.text);
								 else
									$value = MathOp.u_minus(getVariable($ID.text));
								}
	| 	'(' expression ')'		{$value = $expression.value;}
	;


function returns [MathObject value]
	: 	//ID '(' fact (',' (fact)* ')'	
							
	 	ID '(' 				
		f1=fact 			{param.add($f1.value);}
		(',' f2=fact		{param.add($f2.value);
							 if (getVariable($ID.text)!=null) {
								MathMatrix m = (MathMatrix) getVariable($ID.text);
								$value = new MathScalar(m.returnIndex( Integer.parseInt($f1.text), Integer.parseInt($f2.text) ));
							 }
							}
		)? ')'				
							{if (getVariable($ID.text)==null)
								$value = MathOp.call($ID.text, param);
								
								
							 param.clear();	
							}
	;	

	
	

	


// START:tokens
	
ID: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;

INT: ('0'..'9')+ ;

NEWLINE: ('\n'|'\r')+;

WS  :   (' '|'\t')+ {skip();} ;

// END:tokens
