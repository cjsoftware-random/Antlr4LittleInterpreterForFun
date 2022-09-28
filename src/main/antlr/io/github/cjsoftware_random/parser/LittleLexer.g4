lexer grammar LittleLexer;

// Comments and whitespace

// We are sending comments and whitespace to the "hidden" channel which will not be processed
// by our parser. To process a particular channel, you can specify the channel in the CommonTokenStream constructor
// (see Main). By default, CommonTokenStream processes the DEFAULT channel.. which is where your lexical tokens are
// normally sent for processing by your parser.

WHITE_SPACE : [ \t\r\n\u000C]+ -> channel(HIDDEN);

BLOCK_COMMENT:      '/*' .*? '*/'    -> channel(HIDDEN);
LINE_COMMENT:       '//' ~[\r\n]*    -> channel(HIDDEN);

LPAREN : '(';
RPAREN : ')';

PRINT : 'print';

REPEAT : 'repeat';

NUMBER : [0-9]+;

// When we encounter a double quote, we will set the Lexer mode to a custom mode "QUOTED_STRING"
// this allows us to "ignore" the previous lexical definitions and define new rules.
START_QUOTE : '"' -> pushMode(QUOTED_STRING);


mode QUOTED_STRING;
// Our QUOTED_STRING mode is pretty simple. Anything that *isn't* a double quote is a string character.

STRING_CHARS : STR_CHAR+;

fragment STR_CHAR : ~[\\"];

// Wile in QUOTED_STRING mode, if we encounter a double quote.. we "pop" the mode which returns to whatever the
// previous mode was (making the previous lexical definitions take effect again).
END_QUOTE : '"' -> popMode;



