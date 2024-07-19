enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

// Add these task exclusions for gradle tests that we shouldn't need during build execution
gradle.startParameter.excludedTaskNames.addAll(
    listOf(
//        ":buildSrc:testClasses",
//        ":build-logic:convention:testClasses"
    )
)

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Atomic-Habits"
include(":atomic-Android")
include(":shared")