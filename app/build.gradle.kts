import extensions.implementDaggerHilt

plugins {
    id("core-application")
    id("compose")
    id("unit-tests")
    id("logger")
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.midnight.danger.atomichabits"
}

dependencies {
    implementDaggerHilt() // Dagger-Hilt

    debugImplementation(libs.leak.canary)
}