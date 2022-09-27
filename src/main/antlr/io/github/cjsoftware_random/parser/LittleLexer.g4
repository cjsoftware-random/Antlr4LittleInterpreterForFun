lexer grammar LittleLexer;

// Comments and whitespace

WHITE_SPACE : [ \t\r\n\u000C]+ -> channel(HIDDEN);

BLOCK_COMMENT:      '/*' .*? '*/'    -> channel(HIDDEN);
LINE_COMMENT:       '//' ~[\r\n]*    -> channel(HIDDEN);

LPAREN : '(';
RPAREN : ')';

PRINT : 'print';

REPEAT : 'repeat';

NUMBER : [0-9]+;

START_QUOTE : '"' -> pushMode(QUOTED_STRING);

mode QUOTED_STRING;

STRING_CHARS : STR_CHAR+;

END_QUOTE : '"' -> popMode;

fragment STR_CHAR : ~[\\"];

