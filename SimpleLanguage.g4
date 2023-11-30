// SimpleLanguage.g4
grammar SimpleLanguage;

program: statement+;

statement
    : assignment
    | ifStatement
    | printStatement
    ;

assignment: ID ASSIGN expression NEWLINE;

ifStatement: 'if' logicalExpression 'then' statement+ ('else' statement+)? 'fi' NEWLINE;

printStatement: 'print' expression NEWLINE;

expression: ID | NUMBER | expression ('+'|'-') expression;

logicalExpression: expression '==' expression;

ID: [a-zA-Z_][a-zA-Z0-9_]*;
NUMBER: [0-9]+;
ASSIGN: '=';
NEWLINE: '\r'? '\n' | '\r';
WS: [ \t]+ -> skip;
