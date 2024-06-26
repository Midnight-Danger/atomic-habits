package plugins

import constants.Plugins
import constants.ProjectConfigs
import extensions.configureAndroidKotlin
import extensions.libraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class LibraryConventionPlugin: Plugin<Project> {

    override fun apply(project: Project) {
        with(project) {
            // Apply Gradle & Kotlin plugins
            with(pluginManager) {
                apply(Plugins.AndroidLibrary)
                apply(Plugins.KotlinPlugin)
            }

            libraryExtension.apply {
                defaultConfig.apply {
                    minSdk = ProjectConfigs.minSdk
                }

                configureAndroidKotlin(this)
            }
        }
    }
}