package com.example.tabhostdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val btn=findViewById<Button>(R.id.show)
        val rateBar=findViewById<RatingBar>(R.id.ratingBar)
        btn.setOnClickListener {
           val msg= rateBar.rating.toString()
            Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
        }
    }
}