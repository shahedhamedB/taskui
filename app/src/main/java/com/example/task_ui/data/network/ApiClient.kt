package com.example.task_ui.data.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton


/**
 * this class is the responsible for the requesting apis
 *
 */


@Singleton
class Api @Inject constructor(){
        var BASE_URL: String = "http://www.talabyeh.com/Api/"

         val getData: EndpointInterface
        get() {

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addNetworkInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .header("Authorization", "Bearer " + "AccessToken")
                    .header("X-Platform", "android")
                val request = requestBuilder.build()
                chain.proceed(request)
            }.build()

            val rxRetrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return rxRetrofit.create(EndpointInterface::class.java)

        }
}
