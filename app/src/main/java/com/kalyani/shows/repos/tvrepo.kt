package com.kalyani.shows.repos

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.kalyani.shows.models.TvShow
import com.kalyani.shows.models.Tvserial
import com.kalyani.shows.network.tvApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class tvrepo @Inject constructor(var api: tvApi) {
    var data = MutableLiveData<Tvserial>()


    fun gettv(name: String) {
        api.gettvshows(name).enqueue(object : Callback<Tvserial> {
            override fun onResponse(call: Call<Tvserial>, response: Response<Tvserial>) {
                Log.d("tvs", "onResponse: " + response.body())
                data.value = response.body()


            }

            override fun onFailure(call: Call<Tvserial>, t: Throwable) {
                Log.d("tvsfailure", "onResponse: " + t.localizedMessage)
            }

        })
    }

    fun getdata(): MutableLiveData<Tvserial> {
        return data
    }
}