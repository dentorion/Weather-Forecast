package com.entin.data.di

import androidx.annotation.Keep
import com.entin.data.BuildConfig
import com.entin.data.api.ApiWeather
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Dependency Injection for Retrofit
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Keep
    private const val APPID = "appid"

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun provideOkHTTPClientBuilder(int: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(int)
            .addInterceptor { chain ->
                val request = chain.request()
                    .url
                    .newBuilder()
                    .addQueryParameter(APPID, BuildConfig.MY_KEY)
                    .build()

                chain.proceed(
                    chain.request().newBuilder().url(request).build()
                )
            }
            .build()

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson =
        GsonBuilder().create()

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(SERVER_API)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Singleton
    @Provides
    fun provideApiServer(retrofit: Retrofit): ApiWeather =
        retrofit.create(ApiWeather::class.java)

}

private const val SERVER_API = "https://api.openweathermap.org/data/2.5/"