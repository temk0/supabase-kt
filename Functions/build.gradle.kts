plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

description = "Extends supabase-kt with a Edge Functions Client"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        jvmToolchain(8)
        compilations.all {
            kotlinOptions.freeCompilerArgs = listOf(
                "-Xjvm-default=all",  // use default methods in interfaces,
                "-Xlambdas=indy"      // use invokedynamic lambdas instead of synthetic classes
            )
        }
    }
    androidTarget {
        publishLibraryVariants("release", "debug")
    }
    js(IR) {
        browser {
            testTask {
                enabled = false
            }
        }
        nodejs {
            testTask {
                enabled = false
            }
        }
    }
    ios()
    iosSimulatorArm64()
    mingwX64()
    macosX64()
    macosArm64()
    linuxX64()
    watchosArm64()
    watchosX64()
    watchosSimulatorArm64()
    tvos()
    tvosSimulatorArm64()
    sourceSets {
        all {
            languageSettings.optIn("kotlin.RequiresOptIn")
            languageSettings.optIn("io.github.jan.supabase.annotations.SupabaseInternal")
            languageSettings.optIn("io.github.jan.supabase.annotations.SupabaseExperimental")
        }
        val commonMain by getting {
            dependencies {
                api(project(":"))
                api(project(":gotrue-kt"))
            }
        }
    }
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    namespace = "io.github.jan.supabase.functions.library"
    defaultConfig {
        minSdk = 21
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
