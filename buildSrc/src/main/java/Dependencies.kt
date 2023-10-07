object Dependencies {

    const val gradle = "com.android.tools.build:gradle:${Versions.coreVersion}"
    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.gradlepluginVersion}"
    const val saveArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.saveargsVersion}"

    object AndroidX {
        const val core = "androidx.core:core-ktx:${Versions.coreVersion}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintVersion}"
        const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
        const val navUi = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"

        const val workRuntime = "androidx.work:work-runtime-ktx:2.7.1"
        const val paging = "androidx.paging:paging-runtime:3.0.0"
        const val fragment = "androidx.fragment:fragment-ktx:1.5.2"
    }

    object Kotlin {
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    }

    object Google {
        const val gson = "com.google.code.gson:gson:2.9.1"
        const val material = "com.google.android.material:material:${Versions.materialVersion}"
    }
    object Test {
        const val junit = "junit:junit:${Versions.junitVersion}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
        const val junitTest = "androidx.test.ext:junit-ktx:${Versions.junittestVersion}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
        const val compiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"
    }

    object Koin {
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
        const val core = "io.insert-koin:koin-core:${Versions.koin}"
    }

    object Module {
        const val core = ":core"
        const val data = ":data"
        const val domain = ":domain"
    }

    object SquareUp {
        const val okhttp3Logging = "com.squareup.okhttp3:logging-interceptor:4.9.3"
        const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofit2Converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

    object Chucker {
        const val chucker = "com.github.chuckerteam.chucker:library:${Versions.chuckerVersion}"
        const val chuckerNoOp = "com.github.chuckerteam.chucker:library-no-op:${Versions.chuckerVersion}"
    }


}