package com.kalyani.quotesapp.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kalyani.quotesapp.model.allquotesmodel.AllQuoteItem
import com.kalyani.quotesapp.repos.Quotrepo

class QuoteVmodel @ViewModelInject constructor(var repos: Quotrepo) : ViewModel() {


    var quote = MutableLiveData<String>()
    var allquote = MutableLiveData<List<AllQuoteItem>>()
    fun getdataquote() {
        repos.getdata()
        quote = repos.getquotes()
        allquote = repos.getallquotes()

    }

    fun getrandomquote(): MutableLiveData<String> {
        return quote
    }

    fun getallquote(): MutableLiveData<List<AllQuoteItem>> {
        return allquote
    }
}