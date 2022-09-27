package io.github.cjsoftware_random.parservisitor

import io.github.cjsoftware_random.parser.LittleParser
import io.github.cjsoftware_random.parser.LittleParserBaseVisitor

class StatementVisitor : LittleParserBaseVisitor<Unit>() {

    override fun visitPrintStatement(ctx: LittleParser.PrintStatementContext) {
        println(ctx.stringLiteral().accept(VisitStringLiteral()))
    }

    override fun visitRepeatStatement(ctx: LittleParser.RepeatStatementContext) {
        val loopCount = ctx.numericLiteral().accept(VisitNumericLiteral())
        for (repeat in 0 until loopCount) {
            ctx.statement().accept(StatementVisitor())
        }
    }

    override fun visitBlockStatement(ctx: LittleParser.BlockStatementContext) {
        ctx.statement().forEach {
            it.accept(StatementVisitor())
        }
    }
}