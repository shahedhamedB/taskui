package com.example.task_ui.data.network

import com.example.task_ui.data.model.home.CategoriesWrapper
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import javax.inject.Singleton


/**
 * this class is the responsible for the endpoints
 *
 */

@Singleton
interface EndpointInterface {


    @GET("categories")
    fun getCategories(): Observable<CategoriesWrapper>
}
