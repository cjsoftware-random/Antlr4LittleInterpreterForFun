import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/*
 * Note that there are convenience run configurations included in this project
 */

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    kotlin("jvm") version "1.7.10"
    id("io.github.cjsoftware-plugin.Antlr4SyntaxRailroadDiagram") version "1.0.0043"
    antlr // Remember to specify the Antlr version in dependencies or weird errors will happen :-)
    application
}

group = "io.github.cjsoftware_random"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    antlr("org.antlr:antlr4:4.11.1") // Important; specify version, or it will assume a low-version default.
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}


antlr4SyntaxRailroadDiagram {
    inputGrammarName = "LittleParser"
    documentTitle = "A Little Parser"
    documentName = "LittleParserSyntax.html"
    outputDirectory = "$buildDir/Docs"
}

tasks.generateGrammarSource {
    maxHeapSize = "64m"

    arguments.addAll(
        arrayOf(
            "-visitor",
            "-no-listener",
            "-package", "${project.group}.parser",
        )
    )
}

tasks.compileKotlin {
    dependsOn(
        tasks["generateGrammarSource"], // Note that unfortunately the Antlr task is not too great at detecting grammar changes. You may need to clean/assemble.
        tasks["antlr4SyntaxRailroadDiagram"] // Including the syntax diagram for fun.
    )
}

application {
    mainClass.set("${project.group}.Main")
}

