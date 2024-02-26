package plugins

import extensions.implementation
import extensions.ksp
import extensions.vcBundle
import extensions.vcLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.libsDirectory

class DependencyInjectionConventionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with (project) {
            with(pluginManager) {
                apply("com.google.dagger.hilt.android")
            }

            dependencies {
                implementation(vcBundle("dagger"))
                ksp(vcLibrary("dagger-hilt-compiler"))
            }
        }
    }
}