/*
 * Antlr4LittleInterpreterForFun  Copyright (C) 2022  Chris James
 * This program comes with ABSOLUTELY NO WARRANTY;
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; See LICENSE file accompanying this project.
 */

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