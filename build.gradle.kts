import org.codehaus.groovy.ast.tools.GeneralUtils.args

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    alias(libs.plugins.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.ktlint) apply false
    alias(libs.plugins.dagger.hilt) apply false
    alias(libs.plugins.ksp) apply false
}

val installGitHooks by tasks.register<Copy>("installGitHooks") {
    group = "git hooks"
    description = "Copy pre-commit git hook from the scripts to the .git/hooks folder."
    outputs.upToDateWhen { false }
    args("-R", "+x", ".git/hooks/")
    from(File(rootProject.rootDir, ".git-hooks/pre-commit"))
    into { File(rootProject.rootDir, ".git/hooks") }
    fileMode = "0777".toInt(radix = 8)
    doLast {
        logger.info("Git hooks installed successfully.")
    }
}

tasks.getByPath(":app:preBuild").dependsOn(installGitHooks)