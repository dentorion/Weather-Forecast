@file:Suppress("unused")

package dependencies

object Retrofit {
    /**
     * [Converter: Gson](https://mvnrepository.com/artifact/com.squareup.retrofit2/converter-gson)
     * A Retrofit Converter which uses Gson for serialization.
     */
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.gson}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"

    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
}