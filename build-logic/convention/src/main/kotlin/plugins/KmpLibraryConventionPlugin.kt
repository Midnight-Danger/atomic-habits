package plugins

import constants.PluginDef
import constants.ProjectConfig
import extensions.configureAndroidKotlin
import extensions.configureKotlinMultiplatform
import extensions.kmpExtension
import extensions.libraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KmpLibraryConventionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with(project) {
            with(pluginManager) {
                apply(PluginDef.KotlinMultiplatformPlugin)
                apply(PluginDef.AndroidLibrary)
            }

            configureKotlinMultiplatform(kmpExtension)
            libraryExtension.apply {
                compileSdk = ProjectConfig.targetSdk
                defaultConfig.apply {
                    minSdk = ProjectConfig.minSdk
                }

                configureAndroidKotlin(this)
            }
        }
    }
}