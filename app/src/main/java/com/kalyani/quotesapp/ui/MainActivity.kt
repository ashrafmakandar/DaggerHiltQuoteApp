package com.kalyani.quotesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kalyani.quotesapp.R
import com.kalyani.quotesapp.viewmodel.QuoteVmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var quoteVmodel=ViewModelProvider(this).get(QuoteVmodel::class.java)
        quoteVmodel.getdataquote()
        generatequote.setOnClickListener {
            quoteVmodel.getdataquote()
        }
        quoteVmodel.getrandomquote().observe(this, Observer {
            quote_from_api.text = it.toString()
        })
    }
}