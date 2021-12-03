import Libs.addComposeDependencies

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("plugin.serialization")
    kotlin("kapt")
}

android {
    compileSdkVersion(AndroidSdk.compile)
    defaultConfig {
        applicationId = "com.detsimov.leakchecker"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = App.versionCode
        versionName = App.versionName
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Libs.Version.compose
        kotlinCompilerVersion = kotlinVersion
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(Libs.coreKtx)
    implementation(Libs.material)
    implementation(Libs.appcompat)
    implementation(Libs.lifecycleRuntime)
    implementation(Libs.koin)
    implementation(Libs.koinAndroid)
    implementation(Libs.koinAndroidCompose)
    implementation(Libs.orbitAndroid)
    implementation(Libs.result)
    implementation(Libs.ktor)
    implementation(Libs.ktorAndroid)
    implementation(Libs.ktorLogging)
    implementation(Libs.ktorSerialization)
    implementation(Libs.room)
    implementation(Libs.roomKtx)
    kapt(Libs.roomCompiler)
    addComposeDependencies()
}