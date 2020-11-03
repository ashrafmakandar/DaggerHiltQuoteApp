package com.kalyani.shows.network

import com.kalyani.shows.models.Tvserial
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface tvApi {
    @GET("show-details")
    fun gettvshows(@Query("q") name: String): Call<Tvserial>
}