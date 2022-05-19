plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    compileSdk = Android.compileSdk

    defaultConfig {
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "MY_KEY", "\"df1ee0367e6974fa69fe0e7494fdf336\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(mapOf("path" to ":domain")))

    // Hilt
    Dependencies.hilt.apply {
        implementation(mainHilt)
        kapt(compileAndroid)
    }

    // Coroutines
    Dependencies.coroutines.apply {
        api(coreCoroutines)
        api(androidCoroutines)
    }

    // Retrofit + logging interceptor
    Dependencies.retrofit.apply {
        implementation(gson)
        implementation(retrofit)
        implementation(loggingInterceptor)
    }

}