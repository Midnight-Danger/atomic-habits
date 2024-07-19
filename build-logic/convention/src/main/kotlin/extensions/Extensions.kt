@file:Suppress("unused")
package extensions

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.BaseExtension
import constants.DependencyConfig
import org.gradle.api.Project
import org.gradle.api.artifacts.ExternalModuleDependencyBundle
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionConstraint
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.getByType

internal val Project.applicationExtension: ApplicationExtension
    get() = extensions.getByType<ApplicationExtension>()

internal val Project.libraryExtension: LibraryExtension
    get() = extensions.getByType<LibraryExtension>()

internal val Project.androidExtension
    get() = project.extensions.getByName(DependencyConfig.ANDROID) as? BaseExtension

internal fun Project.vcVersion(alias: String): VersionConstraint =
    libs.findVersion(alias).get()

internal fun Project.vcLibrary(alias: String): Provider<MinimalExternalModuleDependency> =
    libs.findLibrary(alias).get()

internal fun Project.vcBundle(alias: String): Provider<ExternalModuleDependencyBundle> =
    libs.findBundle(alias).get()

internal fun DependencyHandlerScope.implementation(dependency: Any) {
    add(DependencyConfig.IMPL, dependency)
}

internal fun DependencyHandlerScope.debugImplementation(dependency: Any) {
    add(DependencyConfig.DEBUG_IMPL, dependency)
}

internal fun DependencyHandlerScope.testImplementation(dependency: Any) {
    add(DependencyConfig.TEST_IMPL, dependency)
}

internal fun DependencyHandlerScope.implementationProject(dependency: Any) {
    add(DependencyConfig.IMPL, project(mapOf(DependencyConfig.PATH to dependency)))
}

internal fun DependencyHandlerScope.debugImplementationProject(dependency: Any) {
    add(DependencyConfig.DEBUG_IMPL, project(mapOf(DependencyConfig.PATH to dependency)))
}

internal fun DependencyHandlerScope.androidTestImplementation(dependency: Any) {
    add(DependencyConfig.ANDROID_TEST_IMP, dependency)
}

internal fun DependencyHandlerScope.coreLibraryDesugaring(dependency: Any) {
    add(DependencyConfig.CORE_LIB_DESUGARING, dependency)
}