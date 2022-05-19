plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {

    // Coroutines
    Dependencies.coroutines.apply {
        api(coreCoroutines)
        api(androidCoroutines)
    }
}