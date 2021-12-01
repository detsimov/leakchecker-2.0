import org.gradle.api.artifacts.dsl.DependencyHandler

const val kotlinVersion = "1.5.31"

object App {
    const val versionName = "2.0"
    const val versionCode = 1
}

object AndroidSdk {
    const val min = 23
    const val compile = 31
    const val target = compile
}

object Libs {

    object Version {
        const val coreKtx = "1.3.2"
        const val appcompat = "1.2.0"
        const val material = "1.3.0"
        const val compose = "1.1.0-beta02"
        const val composeActivity = "1.3.1"
        const val composeNavigation = "2.4.0-beta02"
        const val lifecycleRuntime = "2.3.1"
        const val coil = "1.3.1"
        const val koin = "3.1.3"
        const val coroutinesAndroid = "1.5.1"
        const val orbit = "4.3.0"
    }

    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Version.appcompat}"
    const val material = "com.google.android.material:material:${Version.material}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Version.compose}"
    const val composeUi = "androidx.compose.ui:ui:${Version.compose}"
    const val composeUiUtil = "androidx.compose.ui:ui-util:${Version.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Version.compose}"
    const val composeMaterialIconsCore = "androidx.compose.material:material-icons-core:${Version.compose}"
    const val composeMaterialIconsExtended = "androidx.compose.material:material-icons-extended:${Version.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Version.compose}"
    const val composeFoundation = "androidx.compose.foundation:foundation:${Version.compose}"
    const val composeActivity = "androidx.activity:activity-compose:${Version.composeActivity}"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Version.composeNavigation}"
    const val composeCoil = "io.coil-kt:coil-compose:${Version.coil}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycleRuntime}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutinesAndroid}"
    const val koin = "io.insert-koin:koin-core:${Version.koin}"
    const val koinAndroid = "io.insert-koin:koin-android:${Version.koin}"
    const val koinAndroidCompose = "io.insert-koin:koin-androidx-compose:${Version.koin}"
    const val koinViewModel = "io.insert-koin:koin-android-viewmodel:${Version.koin}"
    const val orbitAndroid = "org.orbit-mvi:orbit-viewmodel:${Version.orbit}"


    fun DependencyHandler.addComposeDependencies() {
        impl(composeUi)
        impl(composeUiUtil)
        impl(composeMaterial)
        impl(composeRuntime)
        impl(composeMaterialIconsCore)
        impl(composeMaterialIconsExtended)
        impl(composeUiTooling)
        impl(composeFoundation)
        impl(composeActivity)
        impl(composeNavigation)
        impl(composeCoil)
    }
}

object Plugin {

    object Version {
        const val androidGradle = "7.1.0-beta03"
    }

    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidGradle = "com.android.tools.build:gradle:${Version.androidGradle}"
}