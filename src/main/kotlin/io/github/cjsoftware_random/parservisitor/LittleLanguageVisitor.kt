package io.github.cjsoftware_random.parservisitor

import io.github.cjsoftware_random.parser.LittleParser
import io.github.cjsoftware_random.parser.LittleParserBaseVisitor

// This is our "top level" visitor. We could combine it with the statement visitor
// but it is clearer keeping them separate.
class LittleLanguageVisitor : LittleParserBaseVisitor<Unit>() {

    override fun visitLittleLanguage(ctx: LittleParser.LittleLanguageContext) {
        // To execute our program, we just loop through the statements,
        // executing each one (by visiting them). Super simple.
        ctx.statement().forEach {
            it.accept(StatementVisitor())
        }
    }
}