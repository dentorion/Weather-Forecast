@file:Suppress("unused")

package dependencies

object CanaryLeak {

    /**
     * Canary Leak
     */
    const val canary = "com.squareup.leakcanary:leakcanary-android:${Versions.canary}"
}