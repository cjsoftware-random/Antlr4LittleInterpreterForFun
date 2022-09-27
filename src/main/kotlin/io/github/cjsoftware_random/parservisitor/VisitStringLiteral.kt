package io.github.cjsoftware_random.parservisitor

import io.github.cjsoftware_random.parser.LittleParser
import io.github.cjsoftware_random.parser.LittleParserBaseVisitor

class VisitStringLiteral : LittleParserBaseVisitor<String>() {
    override fun visitStringLiteral(ctx: LittleParser.StringLiteralContext): String {
        return ctx.string.text
    }
}