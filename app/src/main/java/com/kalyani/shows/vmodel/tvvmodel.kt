package com.kalyani.shows.vmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kalyani.shows.models.Tvserial
import com.kalyani.shows.repos.tvrepo
import javax.inject.Inject

class tvvmodel @ViewModelInject constructor(var repo: tvrepo) : ViewModel() {
    var datas = MutableLiveData<Tvserial>()
    fun gettdta(name: String) {
        repo.gettv(name)
        datas = repo.getdata()

    }


    fun getdatas(): MutableLiveData<Tvserial> {
        return datas
    }
}