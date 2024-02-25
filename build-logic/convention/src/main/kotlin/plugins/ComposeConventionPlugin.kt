package plugins

import extensions.androidExtension
import extensions.androidTestImplementation
import extensions.debugImplementation
import extensions.implementation
import extensions.vcBundle
import extensions.vcLibrary
import extensions.vcVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class ComposeConventionPlugin: Plugin<Project> {

    @Suppress("UnstableApiUsage")
    override fun apply(project: Project) {
        with(project) {
            androidExtension?.apply {
                buildFeatures.compose = true // enable compose
                composeOptions {
                    kotlinCompilerExtensionVersion = vcVersion("compose-compiler").toString()
                }

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