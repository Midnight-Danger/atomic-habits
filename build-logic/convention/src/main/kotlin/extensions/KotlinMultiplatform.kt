package extensions

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureKotlinMultiplatform(
    extension: KotlinMultiplatformExtension,
) {
    with(extension) {
        jvmToolchain(17)

        //targets
        androidTarget()
        iosArm64()
        iosX64()
        iosSimulatorArm64()

        applyDefaultHierarchyTemplate()

        sourceSets.apply {
            commonMain.dependencies {
                // KMP Dependencies here
            }

            commonTest.dependencies {
                // KMP test dependencies here
            }

            androidMain.dependencies {
                // Android dependencies here
            }

            iosMain.dependencies {
                // iOS dependencies here
            }
        }
    }
}