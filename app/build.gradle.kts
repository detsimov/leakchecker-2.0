import Libs.addComposeDependencies

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = "com.detsimov.leakchecker"
        minSdkVersion(23)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"
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
    addComposeDependencies()
}