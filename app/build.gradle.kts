import java.io.FileInputStream
import java.util.Properties

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

        buildConfigField("String", "BASE_URL", "\"https://movie-database-alternative.p.rapidapi.com/\"")
        buildConfigField("String", "API_KEY", getApiKey())
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
    with(Dependencies.Module) {
        implementation(project(mapOf("path" to core)))
        implementation(project(mapOf("path" to data)))
        implementation(project(mapOf("path" to domain)))
    }
    with(Dependencies.AndroidX) {
        implementation(appCompat)
        implementation(constraintLayout)
        implementation(navFragment)
        implementation(navUi)
        implementation(fragment)
        implementation(paging)
        implementation(workRuntime)
    }
    with(Dependencies.Koin){
        implementation(core)
        implementation(android)
    }
    with(Dependencies.Glide) {
        implementation(glide)
        annotationProcessor(compiler)
    }
    with(Dependencies.SquareUp) {
        implementation(retrofit2)
        implementation(retrofit2Converter)
        implementation(okhttp3Logging)
    }
    with(Dependencies.Chucker) {
        debugImplementation(chucker)
        releaseImplementation(chuckerNoOp)
    }
    with(Dependencies.Test) {
        testImplementation(junit)
        androidTestImplementation(junitTest)
        androidTestImplementation(espresso)
    }
    with(Dependencies.Room) {
        implementation(runtime)
        kapt(compiler)
    }
}
fun getApiKey(): String {
    val prop = Properties().apply {
        load(FileInputStream(File(rootProject.rootDir, "./local.properties")))
    }
    return prop.getProperty("API_KEY")
}