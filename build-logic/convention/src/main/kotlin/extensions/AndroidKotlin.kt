package extensions

import com.android.build.api.dsl.CommonExtension
import constants.ProjectConfigs
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal fun Project.configureAndroidKotlin(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    with(commonExtension) {
        compileSdk = ProjectConfigs.targetSdk
        defaultConfig.apply {
            minSdk = ProjectConfigs.minSdk
            testInstrumentationRunner = "androidx.test.runner.AndroidJunitRunner"
            vectorDrawables.useSupportLibrary = true
        }
        compileOptions {
            isCoreLibraryDesugaringEnabled = true
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
        packaging.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"

        dependencies {
            coreLibraryDesugaring(vcLibrary("desugar"))
            // Android core dependencies
            implementation(vcLibrary("android-core-ktx"))
            implementation(vcLibrary("android-lifecycle-runtime-ktx"))
        }
    }
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = freeCompilerArgs + listOf("-Xopt-in=kotlin.RequiresOptIn")
        }
    }
}