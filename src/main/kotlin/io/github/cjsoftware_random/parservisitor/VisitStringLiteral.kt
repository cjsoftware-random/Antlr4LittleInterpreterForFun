/*
 * Antlr4LittleInterpreterForFun  Copyright (C) 2022  Chris James
 * This program comes with ABSOLUTELY NO WARRANTY;
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; See LICENSE file accompanying this project.
 */

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