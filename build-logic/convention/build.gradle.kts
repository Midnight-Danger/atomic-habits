plugins {
    `kotlin-dsl`
}

group = "com.midnight.danger.buildlogic"

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidCore"){
            id = "core-application"
            implementationClass = "plugins.ApplicationConventionPlugin"
        }
        register("androidLibrary"){
            id = "core-library"
            implementationClass = "plugins.LibraryConventionPlugin"
        }
        register("daggerHilt") {
            id = "dagger"
            implementationClass = "plugins.DependencyInjectionConventionPlugin"
        }
        register("composeCore"){
            id = "compose"
            implementationClass = "plugins.ComposeConventionPlugin"
        }
        register("timberLogger") {
            id = "logger"
            implementationClass = "plugins.LoggerConventionPlugin"
        }
        register("unitTests"){
            id = "unit-tests"
            implementationClass = "plugins.UnitTestConventionPlugin"
        }
    }
}