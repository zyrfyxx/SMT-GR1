grammar SMT_GR1;


spec: (importState)* specName  (specElem)*;

importState: 'import' '"' NAME ( '.' NAME )* '"';

specName: 'spec' NAME;

specElem: varDec ';'
        | assumption ';'
        | guarantee ';'
        ;

varDec: KIND TYPE NAME                                   # decWithoutEnum
        | KIND '{' (NAME',')* NAME '}' enumName=NAME             # enumDec
      ;



assumption: 'asm' tempConstraint    # asmTempConstraint
        | 'asm' pattern            # asmPattern
        ;

guarantee: 'gar' tempConstraint    # garTempConstraint
        | 'gar' pattern           # gatPattern
        ;

pattern: NAME '(' ((NAME | exp) ',')* (NAME | exp) ')' ;

tempConstraint: 'ini' exp
              | 'alw' exp
              | 'alwEv' exp
              ;

exp: arithmeticComparison
   | LPAREN exp RPAREN
   | unaryOp exp
   | exp binaryOp exp
   | primExp
   ;

unaryOp: NOT
       | NEXT
       ;

binaryOp:
        | EQ
        | AND
        | OR
        | IMPL
        | EQUIV
        ;

primExp: TRUE
       | FALSE
       | NAME
       ;

arithmeticComparison: subexp predicate subexp
;

subexp:
      INT
      | FLOAT
      | NAME
      | NEXT subexp
      | LPAREN subexp RPAREN
      | subexp MUL subexp
      | subexp DIV subexp
      | subexp PLUS subexp
      | subexp MINUS subexp
      | subexp SQUARE subexp


      ;



predicate: LT
         | GT
         | EQ
         | NEQ
         | LTE
         | GTE
         ;



value: INT
     | FLOAT
     ;

TYPE: 'boolean'
    | 'int'
    | 'float'
    ;

KIND: 'sys'
    | 'env'
    ;

INT       : [0-9]+;
FLOAT     : [0-9]+ '.' [0-9]+;
PLUS      : '+';
MINUS     : '-';
MUL       : '*';
DIV       : '/';
SQUARE    : '**';
LT        : '<';
GT        : '>';
LTE        : '<=';
GTE        : '>=';
EQ        : '=';
NEQ       : '!=';
AND       : '&';
OR        : '|';
IMPL      : '->';
EQUIV     : '<->';
NOT       : '!';
NEXT      : 'next';
TRUE      : 'true';
FALSE     : 'false';
LPAREN    : '(';
RPAREN    : ')';
NAME      : ID;
ID        : [a-zA-Z_0-9]+;
WS        : [ \t\r\n]+ -> channel(HIDDEN);