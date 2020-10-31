package com.kalyani.quotesapp.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kalyani.quotesapp.repos.Quotrepo

class QuoteVmodel @ViewModelInject constructor(var repos: Quotrepo) : ViewModel() {


    var quote = MutableLiveData<String>()
    fun getdataquote() {
        repos.getdata()
        quote = repos.getquotes()

    }

    fun getrandomquote(): MutableLiveData<String> {
        return quote
    }
}