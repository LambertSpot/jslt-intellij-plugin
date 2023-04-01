plugins {
    id("org.jetbrains.intellij") version "1.13.3"
    kotlin("jvm") version "1.8.10"
    id("org.jetbrains.grammarkit") version "2022.3.1"
}

group = "net.stefanfuchs.jslt.intellij.language"
version = "1.0.6"

repositories {
    mavenCentral()
}

val includeInJar by configurations.creating {
    isTransitive = false
}

dependencies {
    val jsltLibVersion = "0.1.14"
    implementation(kotlin("stdlib"))
    implementation("com.schibsted.spt.data:jslt:$jsltLibVersion")
    includeInJar("com.schibsted.spt.data:jslt:$jsltLibVersion") // explicitly include this file in the build step
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("2023.1")
    plugins.set(listOf("org.jetbrains.plugins.yaml"))
}

grammarKit {
    // Version of IntelliJ patched JFlex (see the link below), Default is 1.7.0-1
    jflexRelease.set("1.7.0-2")

    // Release version, tag, or short commit hash of Grammar-Kit to use (see link below). Default is 2021.1.2
    grammarKitRelease.set("2021.1.2")

    // Optionally provide an IntelliJ version to build the classpath for GenerateParser/GenerateLexer tasks
    intellijRelease.set("231.8109.175")
}


// Include the generated files in the source set
sourceSets {
    main {
        java {
            srcDirs("src/main/gen")
        }
    }
}


tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
    generateLexer {
        // source flex file
        sourceFile.set(File("src/main/grammar/jslt.flex"))

        // target directory for lexer
        targetDir.set("src/main/gen/net/stefanfuchs/jslt/intellij/language/")

        // target classname, target file will be targetDir/targetClass.java
        targetClass.set("JsltLexer")

        // if set, plugin will remove a lexer output file before generating new one. Default: false
        purgeOldFiles.set(true)
    }

    // IMPORTANT: there is an open issue (https://github.com/JetBrains/gradle-grammar-kit-plugin/issues/23)
    // which block the proper code generation using the Gradle Plugin
    // (the utility methods that can be referenced using the psiImplUtilClass bnf config are not found)
    // which means, that the parser generator must be run twice
    // one may use IntelliJ Plugin (https://plugins.jetbrains.com/plugin/6606-grammar-kit) to do that

    generateParser {
        // source bnf file
        sourceFile.set(File("src/main/grammar/jslt.bnf"))

        // optional, task-specific root for the generated files. Default: none
        targetRoot.set("src/main/gen")

        // path to a parser file, relative to the targetRoot
        pathToParser.set("/net/stefanfuchs/jslt/intellij/language/parser/JsltParser.java")


        pathToPsiRoot.set("/net/stefanfuchs/jslt/intellij/language/psi") // path to a directory with generated psi files, relative to the targetRoot

        // if set, the plugin will remove a parser output file and psi output directory before generating new ones. Default: false
        purgeOldFiles.set(true)
    }

    jar {
        from(zipTree(includeInJar.singleFile))
    }

//    patchPluginXml {
//        changeNotes.set("""
//            Add change notes here.<br>
//            <em>most HTML tags may be used</em>        """.trimIndent())
//    }
}
