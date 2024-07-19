package plugins

import constants.PluginDef
import constants.ProjectConfig
import extensions.applicationExtension
import extensions.configureAndroidKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project

class ApplicationConventionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with(project) {
            // Apply Gradle & Kotlin plugins
            with(pluginManager) {
                apply(PluginDef.AndroidGradlePlugin)
                apply(PluginDef.KotlinPlugin)
            }

            applicationExtension.apply {
                defaultConfig.apply {
                    minSdk = ProjectConfig.minSdk
                    targetSdk = ProjectConfig.targetSdk
                }

                configureAndroidKotlin(this)
            }
        }
    }
}