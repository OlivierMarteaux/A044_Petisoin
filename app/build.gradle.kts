plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
}

android {
    namespace = "com.example.a044_petisoin"
    compileSdk = 35


    room {
        // Enables exporting database schemas into JSON files in the given directory.
        schemaDirectory("$projectDir/schemas")
    }

    defaultConfig {
        applicationId = "com.example.a044_petisoin"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        ksp.apply {
            // Enables exporting database schemas into JSON files in the given directory.
//            arg("room.schemaLocation", "$projectDir/schemas")
            // Enables Gradle incremental annotation processor. Default value is true.
            arg("room.incremental", "true")
            // Generate Kotlin source files instead of Java. Requires KSP. Default value is true as of version 2.7.0.
            arg("room.generateKotlin", "true")
        }


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // ROOM
    implementation(libs.androidx.room.runtime)
    // If this project uses any Kotlin source, use Kotlin Symbol Processing (KSP)
    ksp(libs.androidx.room.compiler)
    // If this project only uses Java source, use the Java annotationProcessor
    // No additional plugins are necessary
    // annotationProcessor(libs.androidx.room.compiler)
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)

    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.kotlinx.coroutines.test)
}