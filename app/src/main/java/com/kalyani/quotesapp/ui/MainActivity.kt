package com.kalyani.quotesapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.view.menu.MenuBuilder
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kalyani.quotesapp.R
import com.kalyani.quotesapp.adapters.quoteadapter
import com.kalyani.quotesapp.model.allquotesmodel.AllQuoteItem
import com.kalyani.quotesapp.viewModels
import com.kalyani.quotesapp.viewmodel.QuoteVmodel
import com.kalyani.shows.ui.Tv
import com.kalyani.shows.vmodel.tvvmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val quoteVmodel: QuoteVmodel by viewModels()
    val tvvmodel: tvvmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rpg.visibility = View.INVISIBLE
        quoteVmodel.getdataquote()
        recview.visibility = View.GONE
        generatequote.setOnClickListener {
            quoteVmodel.getdataquote()
            rpg.visibility = View.VISIBLE

        }
        quoteVmodel.getrandomquote().observe(this, Observer {
            quote_from_api.text = it.toString()
            rpg.visibility = View.INVISIBLE
        })
        quoteVmodel.getallquote().observe(this, Observer {

            var adapter = quoteadapter(applicationContext, it)
            //Toast.makeText(this, "" + it, Toast.LENGTH_SHORT).show()
            recview.layoutManager = LinearLayoutManager(this)
            recview.adapter = adapter
            recview.setHasFixedSize(true)

        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menus, menu)

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.allquote -> {
                recview.visibility = View.VISIBLE
                rel.visibility = View.GONE


            }
            R.id.alltv -> {
                var intent = Intent(applicationContext, Tv::class.java)
                startActivity(intent)
            }


        }
        return super.onOptionsItemSelected(item)
    }
}