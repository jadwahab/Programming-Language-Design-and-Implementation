grammar T;

prog	:	 expr+ EOF
	;
	
expr : ID 
	; 



Letter: 'a'..'z';
Digit: '0'..'9';

// START:tokens
ID  :   Letter(Digit)*;
WS  :   (' '|'\t'|'\n'|'\r')+ {skip();} ;

// END:tokens
