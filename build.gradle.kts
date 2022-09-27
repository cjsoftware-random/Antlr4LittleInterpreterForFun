import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    kotlin("jvm") version "1.7.10"
    id("io.github.cjsoftware-plugin.Antlr4SyntaxRailroadDiagram") version "1.0.0043"
    antlr
    application
}

val groupName = "io.github.cjsoftware_random"

group = groupName
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    antlr("org.antlr:antlr4:4.11.1") // Important; specify version or it will assume a low-version default.
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
            "-package", "$groupName.parser",
        )
    )
}

tasks.compileKotlin {
    dependsOn(tasks["generateGrammarSource"])
}

application {
    mainClass.set("$groupName.Main")
}

