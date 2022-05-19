@file:Suppress("unused")

package dependencies

object Room {

    /**
     * [Android Room Runtime](https://mvnrepository.com/artifact/androidx.room/room-runtime)
     */
    const val runtime = "androidx.room:room-runtime:${Versions.room}"

    /**
     * [Android Room Kotlin Extensions](https://mvnrepository.com/artifact/androidx.room/room-ktx)
     */
    const val ktx = "androidx.room:room-ktx:${Versions.room}"

    /**
     * [Android Room Compiler](https://mvnrepository.com/artifact/androidx.room/room-compiler)
     */
    const val compiler = "androidx.room:room-compiler:${Versions.room}"

    /**
     * To use Kotlin annotation processing tool (kapt)
     */
    const val annotation = "androidx.room:room-compiler:${Versions.room}"

}