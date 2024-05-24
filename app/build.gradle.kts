import Git_hooks_gradle.InstallGitHooks
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    id(Plugins.Convention.Application)
    alias(libs.plugins.ksp)
    id(Plugins.Convention.Compose)
    id(Plugins.Convention.DaggerHilt)
    id(Plugins.Convention.UnitTests)
    id(Plugins.Convention.Logger)
}

android {
    namespace = "com.midnight.danger.atomichabits"
}

dependencies {
    debugImplementation(libs.leak.canary)
}

ktlint {
    android.set(true)
    outputToConsole.set(true)
    outputColorName.set("RED")
    ignoreFailures.set(true)
    reporters {
        reporter(ReporterType.PLAIN)
        reporter(ReporterType.CHECKSTYLE)
    }
}

val installGitHooks by tasks.register<InstallGitHooks>(Tasks.InstallGitHooks.NAME) {
    fromFile = File(rootProject.rootDir, Tasks.InstallGitHooks.SOURCE_DIR)
    intoFile = File(rootProject.rootDir, Tasks.InstallGitHooks.TARGET_DIR)
}

tasks.preBuild {
    dependsOn(installGitHooks)
}