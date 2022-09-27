// ANTLR G4
parser grammar LittleParser ;

options {
    // this isn't really necessary for such a simple grammar, but it seems
    // lots of people have trouble building parsers under a specific package
    // ...in this case, we specify the package as a "path" to the lexer rules
    tokenVocab='io/github/cjsoftware_random/parser/LittleLexer';
    caseInsensitive = true;

}

littleLanguage : statement * EOF;

statement : printStatement
          | repeatStatement
          | blockStatement
          ;

printStatement : PRINT stringLiteral ;

repeatStatement : REPEAT numericLiteral statement ;

blockStatement : LPAREN statement * RPAREN;

stringLiteral : START_QUOTE string=STRING_CHARS END_QUOTE;

numericLiteral : value=NUMBER;