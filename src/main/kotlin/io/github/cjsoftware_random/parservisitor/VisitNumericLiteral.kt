package io.github.cjsoftware_random.parservisitor

import io.github.cjsoftware_random.parser.LittleParser
import io.github.cjsoftware_random.parser.LittleParserBaseVisitor

// A specialised visitor to evaluate and return a number. No error checking.
class VisitNumericLiteral : LittleParserBaseVisitor<Int>() {
    override fun visitNumericLiteral(ctx: LittleParser.NumericLiteralContext): Int {
        return ctx.value.text.toInt()
    }
}