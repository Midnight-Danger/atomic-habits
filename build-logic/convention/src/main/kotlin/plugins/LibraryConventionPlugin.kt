package plugins

import constants.PluginDef
import constants.ProjectConfig
import extensions.configureAndroidKotlin
import extensions.libraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class LibraryConventionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with(project) {
            // Apply Gradle & Kotlin plugins
            with(pluginManager) {
                apply(PluginDef.AndroidLibrary)
                apply(PluginDef.KotlinPlugin)
            }

            libraryExtension.apply {
                defaultConfig.apply {
                    minSdk = ProjectConfig.minSdk
                }

                configureAndroidKotlin(this)
            }
        }
    }
}