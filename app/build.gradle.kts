plugins {
    id(Plugins.androidApp)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.safeArgs)
}

android {
    namespace = "com.achmadfuad.moviedatabase"
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = "com.achmadfuad.moviedatabase"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.versionCode
        versionName = Versions.versionName
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    with(Dependencies.Google) {
        implementation(material)
    }
    with(Dependencies.AndroidX) {
        implementation(appCompat)
        implementation(constraintLayout)
    }
    with(Dependencies.Test) {
        testImplementation(junit)
        androidTestImplementation(junitTest)
        androidTestImplementation(espresso)
    }
}