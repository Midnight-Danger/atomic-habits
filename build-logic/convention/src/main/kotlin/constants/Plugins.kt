package constants

object Plugins {
    internal const val AndroidGradlePlugin = "com.android.application"
    internal const val AndroidLibrary = "com.android.library"
    internal const val KotlinPlugin = "org.jetbrains.kotlin.android"
    internal const val DaggerHiltPlugin = "com.google.dagger.hilt.android"

    object Convention {
        const val Application = "core-application"
        const val Library = "core-library"
        const val DaggerHilt = "dagger-hilt"
        const val Compose = "compose"
        const val Logger = "logger"
        const val UnitTests = "unit-tests"
    }
}