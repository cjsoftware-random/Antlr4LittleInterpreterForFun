/*
 * Antlr4LittleInterpreterForFun  Copyright (C) 2022  Chris James
 * This program comes with ABSOLUTELY NO WARRANTY;
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; See LICENSE file accompanying this project.
 */

package io.github.cjsoftware_random

import io.github.cjsoftware_random.parser.LittleLexer
import io.github.cjsoftware_random.parser.LittleParser
import io.github.cjsoftware_random.parservisitor.LittleLanguageVisitor
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream


object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        """
            /* 
               A very simple example of an interpreter
             */
            repeat 10 (
                print "Hello world!"
                repeat 2 print "--Nesting for fun"
            )
            
            // Can be quite useful at times.
            print "I'm done!"
            
            
            
        """.trimIndent().byteInputStream().use {
            val parser = LittleParser(CommonTokenStream(LittleLexer(CharStreams.fromStream(it))))

            parser.littleLanguage().accept(LittleLanguageVisitor())
        }
    }
}