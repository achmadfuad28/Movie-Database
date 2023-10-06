// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.gradle)
        classpath(Dependencies.gradlePlugin)
        classpath(Dependencies.saveArgs)
    }
}
plugins {
    id(Plugins.androidApp) version Versions.androidVersion apply false
    id(Plugins.library) version Versions.libraryVersion apply false
    id(Plugins.kotlinAndroid) version Versions.kotlinVersion apply false
    id(Plugins.jetbrains) version Versions.jetbrainsVersion apply false
}