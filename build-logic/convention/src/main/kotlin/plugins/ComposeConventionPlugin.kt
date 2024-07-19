package plugins

import constants.PluginDef
import extensions.androidExtension
import extensions.androidTestImplementation
import extensions.debugImplementation
import extensions.implementation
import extensions.vcBundle
import extensions.vcLibrary
import extensions.vcVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

class ComposeConventionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with(project) {
            with(pluginManager) {
                apply(PluginDef.ComposeCompiler)
            }

            androidExtension?.apply {
                buildFeatures.compose = true // enable compose

                dependencies {
                    implementation(platform(vcLibrary("compose-bom")))
                    implementation(vcBundle("compose"))
                    debugImplementation(vcBundle("compose-tooling"))
                    androidTestImplementation(platform(vcLibrary("compose-bom")))
                }
            }
        }
    }
}