package extensions

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.implementDaggerHilt() {
    dependencies {
        implementation(vcBundle("dagger"))
        ksp(vcLibrary("dagger-hilt-compose"))
    }
}