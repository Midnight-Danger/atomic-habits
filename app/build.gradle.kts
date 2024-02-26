plugins {
    id(Plugins.Convention.Application)
    alias(libs.plugins.ksp)
    id(Plugins.Convention.Compose)
    id(Plugins.Convention.DaggerHilt)
    id(Plugins.Convention.UnitTests)
    id(Plugins.Convention.Logger)
}

android {
    namespace = "com.midnight.danger.atomichabits"
}

dependencies {
    debugImplementation(libs.leak.canary)
}