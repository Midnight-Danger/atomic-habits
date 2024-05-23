package plugins

import constants.Plugins
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
                apply(Plugins.AndroidGradlePlugin)
                apply(Plugins.KotlinPlugin)
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