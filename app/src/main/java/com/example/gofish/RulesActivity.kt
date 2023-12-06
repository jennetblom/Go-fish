package com.example.gofish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class RulesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)

        var titleTextView : TextView = findViewById(R.id.theRulesText)
        var fishRulesText = findViewById<ImageView>(R.id.fishRulesImage)
        var rulesTextView1 : TextView = findViewById(R.id.rulesTextView1)
        var rulesTextView2 : TextView = findViewById(R.id.rulesTextView2)
        var rulesTextView3 : TextView = findViewById(R.id.rulesTextView3)
        var rulesText4 : TextView = findViewById(R.id.rulesText4)
        var rulesText5: TextView = findViewById(R.id.rulesText5)
        var rulesText6 : TextView = findViewById(R.id.rulesText6)
        var goBackButton : Button = findViewById(R.id.goBackButton)

        goBackButton.setOnClickListener {
            val intent =  Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }



    }
}