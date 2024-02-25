package plugins

import constants.ProjectConfigs
import extensions.applicationExtension
import extensions.configureAndroidKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project

class ApplicationConventionPlugin: Plugin<Project> {

    override fun apply(project: Project) {
        with(project) {
            // Apply Gradle & Kotlin plugins
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            applicationExtension.apply {
                defaultConfig.apply {
                    minSdk = ProjectConfigs.minSdk
                    targetSdk = ProjectConfigs.targetSdk
                }

                configureAndroidKotlin(this)
            }
        }
    }
}