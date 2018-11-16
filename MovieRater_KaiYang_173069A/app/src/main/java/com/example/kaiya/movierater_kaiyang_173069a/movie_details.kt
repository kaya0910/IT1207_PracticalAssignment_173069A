package com.example.kaiya.movierater_kaiyang_173069a

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_movie_details.*

class movie_details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val intent = intent
        val nameStr = intent.getStringExtra("nameStr")
        val overviewStr = intent.getStringExtra("overviewStr")
        val langStr = intent.getStringExtra("langStr")
        val dateStr = intent.getStringExtra("dateStr")
        val ageStr = intent.getStringExtra("ageStr")

        val movieTitle = findViewById<TextView>(R.id.movieTitle)
        movieTitle.text = nameStr
        val movieOverview = findViewById<TextView>(R.id.movieOverview)
        movieOverview.text = overviewStr
        val movieLang = findViewById<TextView>(R.id.movieLang)
        movieLang.text = langStr
        val movieDate = findViewById<TextView>(R.id.movieDate)
        movieDate.text = dateStr
        val movieAge = findViewById<TextView>(R.id.movieAge)
        movieAge.text = ageStr
    }
}
