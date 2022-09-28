package io.github.cjsoftware_random.parservisitor

import io.github.cjsoftware_random.parser.LittleParser
import io.github.cjsoftware_random.parser.LittleParserBaseVisitor

// A specialised visitor to return a string literal. Again, no erorr checking.
// Note that the grammar defines "string" to exclude the quotation marks.
class VisitStringLiteral : LittleParserBaseVisitor<String>() {
    override fun visitStringLiteral(ctx: LittleParser.StringLiteralContext): String {
        return ctx.string.text
    }
}