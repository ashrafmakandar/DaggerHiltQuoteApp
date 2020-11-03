package com.kalyani.shows.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.kalyani.quotesapp.R
import com.kalyani.quotesapp.viewModels
import com.kalyani.shows.vmodel.tvvmodel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_tv.*

@AndroidEntryPoint
class Tv : AppCompatActivity() {
    val tvvmodel: tvvmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv)

        click.setOnClickListener {
            tvvmodel.gettdta(showname.text.toString())
        }

        rating.visibility = View.INVISIBLE

        tvvmodel.getdatas().observe(this, Observer {

            name.text = "Name  :  " + it.tvShow.name
            descrption.text = "Description\n " + it.tvShow.description
            start_date.text = "Start Date  :  " + it.tvShow.startDate
            country.text = "Country   " + it.tvShow.country
            run_time.text = "Duration  " + it.tvShow.runtime.toString()
            network.text = "Network Channel :  " + it.tvShow.network
            rating.visibility = View.VISIBLE
            genres.text =
                "Genre :  " + it.tvShow.genres[0] + "," + it.tvShow.genres[1] + "" + it.tvShow.genres[2]
            rating.text = "rating  :  " + it.tvShow.rating
            Picasso.get().load(it.tvShow.imageThumbnailPath).into(poster)

        })

    }
}