package io.github.cjsoftware_random.parservisitor

import io.github.cjsoftware_random.parser.LittleParser
import io.github.cjsoftware_random.parser.LittleParserBaseVisitor

class LittleLanguageVisitor : LittleParserBaseVisitor<Unit>() {
    override fun visitLittleLanguage(ctx: LittleParser.LittleLanguageContext) {
        ctx.statement().forEach {
            it.accept(StatementVisitor())
        }
    }
}