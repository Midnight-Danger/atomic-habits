plugins {
    id("core-application")
    id("compose")
}

android {
    namespace = "com.daily.atomic.habits.android"
}

dependencies {
    implementation(projects.shared)
}