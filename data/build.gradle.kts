plugins {
    id(Plugins.library)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
}

android {
    namespace = "com.achmadfuad.data"
    compileSdk = Versions.targetSdk

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk

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
    with(Dependencies.Module) {
        implementation(project(core))
        implementation(project(domain))
    }
    with(Dependencies.Koin){
        implementation(core)
        implementation(android)
    }
    with(Dependencies.Google){
        implementation(gson)
        implementation(material)
    }
    with(Dependencies.AndroidX){
        implementation(paging)
        implementation(core)
        implementation(appCompat)
    }
    with(Dependencies.SquareUp) {
        implementation(retrofit2Converter)
        implementation(retrofit2)
        implementation(okhttp3Logging)
    }
    with(Dependencies.Room) {
        implementation(runtime)
        kapt(compiler)
    }
}