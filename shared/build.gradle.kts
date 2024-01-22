
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version "1.9.20"

}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                // Put your multiplatform dependencies here
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0-RC2")
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx.json)
                implementation(libs.kotlinx.datetime)

            }
        }

        val androidMain by getting {
            dependencies {
                implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
                implementation(libs.ktor.client.android)
                // Add other Android-specific dependencies here if needed
            }
        }

        val iosMain by getting {
            dependencies {
                // iOS-specific dependencies go here
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

android {
    namespace = "com.example.dailypulses"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}
dependencies {
    implementation("androidx.core:core-ktx:+")
    implementation("androidx.core:core-ktx:+")
    implementation("androidx.core:core-ktx:+")
}
