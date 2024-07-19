plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.application).apply(false)
    alias(libs.plugins.library).apply(false)
    alias(libs.plugins.kotlin.android).apply(false)
    alias(libs.plugins.kmp).apply(false)
    alias(libs.plugins.compose.compiler).apply(false)
}
