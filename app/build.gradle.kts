plugins {
    id("core-application")
    id("compose")
    id("unit-tests")
    id("logger")
}

android {
    namespace = "com.midnight.danger.atomichabits"
}

dependencies {
    debugImplementation(libs.leak.canary)
}