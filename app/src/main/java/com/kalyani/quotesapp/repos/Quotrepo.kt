package com.kalyani.quotesapp.repos

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.kalyani.quotesapp.model.Quote
import com.kalyani.quotesapp.model.allquotesmodel.AllQuote
import com.kalyani.quotesapp.network.QuoteApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class Quotrepo @Inject constructor(var api: QuoteApi) {
    var quotes = String
    var qData = MutableLiveData<String>()
    fun getdata() {


        api.getquote().enqueue(object : Callback<Quote> {
            override fun onResponse(call: Call<Quote>, response: Response<Quote>) {

                qData.value = response.body()!!.en + "\n\n" +
                        "Author: " + response.body()!!.author
                Log.d("success", "onResponse: " + response.body())

            }

            override fun onFailure(call: Call<Quote>, t: Throwable) {
                Log.d("failure", "onFailure: " + t.localizedMessage)

            }

        })

        api.getallquotes().enqueue(object : Callback<AllQuote> {
            override fun onResponse(call: Call<AllQuote>, response: Response<AllQuote>) {
                Log.d("all quotes", "onResponse: " + response.body())
            }

            override fun onFailure(call: Call<AllQuote>, t: Throwable) {
                Log.d("all failure", "onFailure: " + t.localizedMessage)
            }


        })
    }

    fun getquotes(): MutableLiveData<String> {
        return qData
    }

}