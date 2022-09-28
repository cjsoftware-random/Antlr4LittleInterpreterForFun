/*
 * Antlr4LittleInterpreterForFun  Copyright (C) 2022  Chris James
 * This program comes with ABSOLUTELY NO WARRANTY;
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; See LICENSE file accompanying this project.
 */

package io.github.cjsoftware_random.parservisitor

import io.github.cjsoftware_random.parser.LittleParser
import io.github.cjsoftware_random.parser.LittleParserBaseVisitor

// A specialised visitor to evaluate and return a number. No error checking.
class VisitNumericLiteral : LittleParserBaseVisitor<Int>() {
    override fun visitNumericLiteral(ctx: LittleParser.NumericLiteralContext): Int {
        return ctx.value.text.toInt()
    }
}