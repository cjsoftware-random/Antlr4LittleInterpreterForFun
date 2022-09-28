/*
Antlr4LittleInterpreterForFun  Copyright (C) 2022  Chris James&#10;This program comes with ABSOLUTELY NO WARRANTY.
This is free software, and you are welcome to redistribute it&#10;under certain conditions; See LICENSE file accompanying this project.
*/
parser grammar LittleParser ;

options {
    // this isn't really necessary for such a simple grammar, but it seems
    // lots of people have trouble building parsers under a specific package
    // ...in this case, we specify the package as a "path" to the lexer rules
    // Note that this file is in a folder structure that matches the package definition in the
    // task configuration in the build script.. "-package", "$groupName.parser"
    tokenVocab='io/github/cjsoftware_random/parser/LittleLexer';

    // Make our language case insensitive.. just for fun.
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

// note the "string=" .. this exposes the STRING_CHARS as a member in the visitor context for convenience.
// This also (very conveniently) excludes the start and end quote from the exposed member.
stringLiteral : START_QUOTE string=STRING_CHARS END_QUOTE;

// Similar trick for numericLiteral. The convenience member makes it easier to retrive the text of the number.
numericLiteral : value=NUMBER;