plugins {
    id(Plugins.library)
    id(Plugins.kotlinAndroid)
}

android {
    namespace = "com.achmadfuad.core"
    compileSdk = Versions.targetSdk

    defaultConfig {
        minSdk = Versions.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    with(Dependencies.Glide) {
        implementation(glide)
        annotationProcessor(compiler)
    }
    with(Dependencies.AndroidX) {
        implementation(navFragment)
        implementation(core)
        implementation(appCompat)
    }
    with(Dependencies.Google) {
        implementation(material)
        implementation(gson)
    }
    implementation(Dependencies.SquareUp.retrofit2)
}