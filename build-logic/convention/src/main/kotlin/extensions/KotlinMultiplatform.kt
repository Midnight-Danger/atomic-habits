package extensions

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureKotlinMultiplatform(
    extension: KotlinMultiplatformExtension,
) {
    with(extension) {
        jvmToolchain(17)

        //targets
        androidTarget().apply {
            compilations.all {
                compileTaskProvider.configure {
                    compilerOptions {
                        jvmTarget.set(JvmTarget.JVM_17)
                    }
                }
            }
        }
        listOf(
            iosX64(),
            iosArm64(),
            iosSimulatorArm64()
        ).forEach {
            it.binaries.framework {
                baseName = "shared"
                isStatic = true
            }
        }

        applyDefaultHierarchyTemplate()

        sourceSets.apply {
            commonMain.dependencies {
                // KMP Dependencies here
            }

            commonTest.dependencies {
                // KMP test dependencies here
                vcLibrary("kotlin-test")
            }

            androidMain.dependencies {
                // Android dependencies here
            }

            androidNativeTest.dependencies {
                // Android test dependencies here
            }

            iosMain.dependencies {
                // iOS dependencies here
            }

            iosTest.dependencies {
                // iOS test dependencies here
            }
        }
    }
}