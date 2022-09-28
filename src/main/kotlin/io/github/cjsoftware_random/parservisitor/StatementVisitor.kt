package io.github.cjsoftware_random.parservisitor

import io.github.cjsoftware_random.parser.LittleParser
import io.github.cjsoftware_random.parser.LittleParserBaseVisitor

// Simple visitor for statements. By overriding the statements we are interested in
// we make the Antlr visitor do a little work for us (It will call the correct method for the
// statement type).
class StatementVisitor : LittleParserBaseVisitor<Unit>() {

    override fun visitPrintStatement(ctx: LittleParser.PrintStatementContext) {
        // Note how we use the string literal visitor to retrieve the text to print.
        println(ctx.stringLiteral().accept(VisitStringLiteral()))
    }

    override fun visitRepeatStatement(ctx: LittleParser.RepeatStatementContext) {
        // Note how we use the numeric literal visitor to retrieve the number of times to repeat..
        val loopCount = ctx.numericLiteral().accept(VisitNumericLiteral())
        for (repeat in 0 until loopCount) {
            // We are re-using our instance to visit the repeated statement.
            // be careful doing this if you have any local instance properties.
            ctx.statement().accept(this)
        }
    }

    override fun visitBlockStatement(ctx: LittleParser.BlockStatementContext) {
        ctx.statement().forEach {
            // We are re-using our instance to visit the repeated statement.
            // be careful doing this if you have any local instance properties.
            it.accept(this)
        }
    }
}