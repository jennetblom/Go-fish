package com.example.gofish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val oceanImage1 = findViewById<ImageView>(R.id.oceanImage1)
        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)
        val cardGameTextView = findViewById<TextView>(R.id.cardGameTextView)
        val fishImage = findViewById<ImageView>(R.id.fishImage)
        val howButton = findViewById<Button>(R.id.howButton)
        val playButton = findViewById<Button>(R.id.playButton)


        playButton.setOnClickListener {
            val intent =  Intent(this, GameActivity::class.java)
            startActivity(intent)
        }


    }


}