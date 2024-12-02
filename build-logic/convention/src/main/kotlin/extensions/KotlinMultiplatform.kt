package extensions

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

internal fun Project.configureKotlinMultiplatform(
    extension: KotlinMultiplatformExtension,
) {
    with(extension) {
        jvmToolchain(17)

        //android targets
        androidTarget().apply {
            compilations.all {
                compileTaskProvider.configure {
                    compilerOptions {
                        jvmTarget.set(JvmTarget.JVM_17)
                    }
                }
            }
        }

        // iOS Targets
        val xcFrameworkName = "Shared"
        val xcf = XCFramework(xcFrameworkName)
        listOf(
            iosX64(),
            iosArm64(),
            iosSimulatorArm64()
        ).forEach {
            it.binaries.framework {
                baseName = xcFrameworkName

                // Specify CFBundleIdentifier to uniquely identify the framework
                binaryOption("bundleId", "com.daily.atomic.habits.${xcFrameworkName}")
                xcf.add(this)
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
                implementation(vcLibrary("kotlin-test"))
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