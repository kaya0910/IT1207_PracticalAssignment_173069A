package com.example.kaiya.movierater_kaiyang_173069a

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.text.TextUtils
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onCheckBoxClicked(v: View) {
        if (chkbxRating.isChecked == true) {
            chkbxReason.setVisibility(View.VISIBLE)
        } else {
            chkbxReason.setVisibility(View.INVISIBLE)

        }
    }

    fun btnAdd(v: View) {

        var language: String = "";

        if (english.isChecked) {
            language = "English"
        } else if (chinese.isChecked) {
            language = "Chinese"
        } else if (malay.isChecked) {
            language = "Malay"
        } else if (tamil.isChecked) {
            language = "Tamil"
        }

        var ageRating: String = ""

        if(chkbxRating.isChecked)
        {
            ageRating = "No"
        }
        else
        {
            ageRating = "Yes"
        }


        var all_reason: String = "";

        if (Violence.isChecked == true && LangUsed.isChecked == true) {
            all_reason = "Violence\nLanguage Used"
        } else if (Violence.isChecked == true) {
            all_reason = "Violence"
        } else if (LangUsed.isChecked == true) {
            all_reason = "Language Used"
        }

        var count:Int = 0

        val movieName = movie_name.text.toString().trim()
        val movieDate = movie_date  .text.toString().trim()
        val movieDesc = movie_desc.text.toString().trim()

        if(movieName.isEmpty()){
            movie_name.setError("Field Empty!");
            count += 1
        }

        if(movieDate.isEmpty()){
            movie_date.setError("Field Empty!");
            count += 1
        }
        if(movieDesc.isEmpty()){
            movie_desc.setError("Field Empty!");
            count += 1
        }


        //toast
        if (count == 0){
            Toast.makeText(
                this,
                "Title = " + movie_name.text + "\nDescription = " + movie_desc.text + "\nRelease Date = " + movie_date.text + "\nLanguage = " + language + "\nSuitable for all ages = " + chkbxRating.isChecked + "\nReason: \n" + all_reason,
                Toast.LENGTH_LONG
            ).show()

            val name = findViewById<EditText>(R.id.movie_name)
            val nameStr = name.text.toString()
            val overview = findViewById<EditText>(R.id.movie_desc)
            val overviewStr = overview.text.toString()
            val langStr = language
            val date = findViewById<EditText>(R.id.movie_date)
            val dateStr = date.text.toString()
            val ageStr = ageRating


            val intent = Intent(this@MainActivity, movie_details::class.java)

            intent.putExtra("nameStr", nameStr)
            intent.putExtra("overviewStr", overviewStr)
            intent.putExtra("langStr", langStr)
            intent.putExtra("dateStr", dateStr)
            intent.putExtra("ageStr", ageStr)

            startActivity(intent);
        }



    }
}
