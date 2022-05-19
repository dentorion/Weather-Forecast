plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Android.compileSdk
    buildToolsVersion = Android.buildTools

    defaultConfig {
        applicationId = "com.entin.weather"
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = 1
        versionName = "1"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {

    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":data")))

    // Main dependencies of project
    Dependencies.base.apply {
        implementation(coreKtx)
        implementation(appcompat)
        implementation(material)
        implementation(constraintlayout)
        implementation(fragment)
    }

    // Hilt
    Dependencies.hilt.apply {
        implementation(mainHilt)
        kapt(compileAndroid)
    }

    // NAVIGATION COMPONENT
    Dependencies.navigation.apply {
        implementation(mainNavigation)
        implementation(ui)
    }

    // Lifecycle + ViewModel & LiveData
    Dependencies.lifecycle.apply {
        implementation(lifecycle)
        implementation(liveData)
        implementation(viewModel)
    }

    // Recyclerview
    Dependencies.recyclerview.apply {
        implementation(recyclerview)
    }

    // Epoxy Recycler View
    Dependencies.epoxy.apply {
        kapt(epoxyProcessor)
        implementation(androidEpoxy)
    }

    // Solves problem with carousel elements moving
    Dependencies.gravitySnapHelper.apply {
        implementation(helper)
    }

    // Glide
    Dependencies.glide.apply {
        implementation(glide)
    }

    // Leak Canary
    Dependencies.leakCanary.apply {
        debugImplementation(canary)
    }

    // Splash screen
    Dependencies.splashScreen.apply {
        implementation(splashScreen)
    }

    // Retrofit + logging interceptor
    Dependencies.retrofit.apply {
        implementation(gson)
        implementation(retrofit)
        implementation(loggingInterceptor)
    }

    // Gson
    Dependencies.gson.apply {
        implementation(gson)
    }
}

kapt {
    correctErrorTypes = true
}