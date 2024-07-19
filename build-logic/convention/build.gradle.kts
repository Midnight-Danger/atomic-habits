plugins {
    `kotlin-dsl`
}

group = "com.daily.atomic.habits.buildlogic"

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
        register("androidApp"){
            id = "core-application"
            implementationClass = "plugins.ApplicationConventionPlugin"
        }
        register("androidLibrary"){
            id = "core-library"
            implementationClass = "plugins.LibraryConventionPlugin"
        }
        register("kmpLibrary"){
            id = "kmp-library"
            implementationClass = "plugins.KmpLibraryConventionPlugin"
        }
        register("composeCore"){
            id = "compose"
            implementationClass = "plugins.ComposeConventionPlugin"
        }
    }
}