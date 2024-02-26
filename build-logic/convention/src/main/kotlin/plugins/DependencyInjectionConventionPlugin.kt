package plugins

import constants.Plugins
import extensions.implementation
import extensions.ksp
import extensions.vcBundle
import extensions.vcLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class DependencyInjectionConventionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with (project) {
            with(pluginManager) {
                apply(Plugins.DaggerHiltPlugin)
            }

            dependencies {
                implementation(vcBundle("dagger"))
                ksp(vcLibrary("dagger-hilt-compiler"))
            }
        }
    }
}