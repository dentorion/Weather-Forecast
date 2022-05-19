buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Android.gradleVersion}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")

        // HILT
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Android.hiltVersion}")

        // Safe Args
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Android.navigation}")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}