package com.kalyani.quotesapp.network

import com.kalyani.quotesapp.model.Quote
import retrofit2.Call
import retrofit2.http.GET

interface QuoteApi {


    @GET("random")
    fun getquote(): Call<Quote>

}