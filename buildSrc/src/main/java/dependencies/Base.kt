@file:Suppress("unused")

package dependencies

object Base {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"

    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val swipe = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipe}"

    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val jUnitTest = "androidx.test.ext:junit:${Versions.jUnitTest}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}