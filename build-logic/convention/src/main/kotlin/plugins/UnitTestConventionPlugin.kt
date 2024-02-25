package plugins

import extensions.androidTestImplementation
import extensions.testImplementation
import extensions.vcBundle
import extensions.vcLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class UnitTestConventionPlugin: Plugin<Project> {

    override fun apply(project: Project) {
        with(project) {
            dependencies {
                // Core test dependencies
                testImplementation(vcLibrary("junit"))
                androidTestImplementation(vcBundle("androidTests"))
            }
        }
    }
}