plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    kotlin("plugin.serialization") version "2.0.21"
    id("androidx.room")
    id("kotlin-kapt")
}

android {
    namespace = "ru.effective_mobile.courses.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 23

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    room {
        schemaDirectory("$projectDir/schemas")
    }
}

dependencies {
    implementation(project(":domain"))

    //DI
    // https://mvnrepository.com/artifact/io.insert-koin/koin-core
    implementation(libs.koin.android)

    //Flow
    implementation(libs.kotlinx.coroutines.core)

    //Ktor
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)

    //Serialization
    implementation(libs.kotlinx.serialization.json)

    //backport of the java.time
    implementation(libs.threetenabp)

    //Room
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    //DataStore
    implementation(libs.androidx.datastore.preferences)

}