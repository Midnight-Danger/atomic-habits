@file:Suppress("unused")
package extensions

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.BaseExtension
import constants.DependencyConfigs
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
    get() = project.extensions.getByName(DependencyConfigs.ANDROID) as? BaseExtension

internal fun Project.vcVersion(alias: String): VersionConstraint {
    return versionCatalog().findVersion(alias).get()
}

internal fun Project.vcLibrary(alias: String): Provider<MinimalExternalModuleDependency> {
    return versionCatalog().findLibrary(alias).get()
}

internal fun Project.vcBundle(alias: String): Provider<ExternalModuleDependencyBundle> {
    return versionCatalog().findBundle(alias).get()
}

internal fun DependencyHandlerScope.implementation(dependency: Any) {
    add(DependencyConfigs.IMPL, dependency)
}

internal fun DependencyHandlerScope.debugImplementation(dependency: Any) {
    add(DependencyConfigs.DEBUG_IMPL, dependency)
}

internal fun DependencyHandlerScope.testImplementation(dependency: Any) {
    add(DependencyConfigs.TEST_IMPL, dependency)
}

internal fun DependencyHandlerScope.implementationProject(dependency: Any) {
    add(DependencyConfigs.IMPL, project(mapOf(DependencyConfigs.PATH to dependency)))
}

internal fun DependencyHandlerScope.debugImplementationProject(dependency: Any) {
    add(DependencyConfigs.DEBUG_IMPL, project(mapOf(DependencyConfigs.PATH to dependency)))
}

internal fun DependencyHandlerScope.androidTestImplementation(dependency: Any) {
    add(DependencyConfigs.ANDROID_TEST_IMP, dependency)
}

internal fun DependencyHandlerScope.coreLibraryDesugaring(dependency: Any) {
    add(DependencyConfigs.CORE_LIB_DESUGARING, dependency)
}