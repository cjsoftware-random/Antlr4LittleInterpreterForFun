package io.github.cjsoftware_random.parservisitor

import io.github.cjsoftware_random.parser.LittleParser
import io.github.cjsoftware_random.parser.LittleParserBaseVisitor

class VisitNumericLiteral : LittleParserBaseVisitor<Int>() {
    override fun visitNumericLiteral(ctx: LittleParser.NumericLiteralContext): Int {
        return ctx.value.text.toInt()
    }
}