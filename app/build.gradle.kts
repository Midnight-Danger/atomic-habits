plugins {
    id("core-application")
    alias(libs.plugins.ksp)
    id("compose")
    id("dagger")
    id("unit-tests")
    id("logger")
}

android {
    namespace = "com.midnight.danger.atomichabits"
}

dependencies {
    debugImplementation(libs.leak.canary)
}