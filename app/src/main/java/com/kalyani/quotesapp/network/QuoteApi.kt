package com.kalyani.quotesapp.network

import com.kalyani.quotesapp.model.Quote
import com.kalyani.quotesapp.model.allquotesmodel.AllQuote
import retrofit2.Call
import retrofit2.http.GET

interface QuoteApi {


    @GET("quotes/random")
    fun getquote(): Call<Quote>


    @GET("quotes")

    fun getallquotes(): Call<AllQuote>
}