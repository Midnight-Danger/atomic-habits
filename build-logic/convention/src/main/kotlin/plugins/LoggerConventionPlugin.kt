package plugins

import extensions.implementation
import extensions.vcLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class LoggerConventionPlugin: Plugin<Project> {

    override fun apply(project: Project) {
        with(project) {
            dependencies {
                implementation(vcLibrary("timber"))
            }
        }
    }
}