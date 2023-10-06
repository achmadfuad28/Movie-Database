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
    }

    object Kotlin {
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    }

    object Google {
        const val material = "com.google.android.material:material:${Versions.materialVersion}"
    }
    object Test {
        const val junit = "junit:junit:${Versions.junitVersion}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
        const val junitTest = "androidx.test.ext:junit-ktx:${Versions.junittestVersion}"
    }

}