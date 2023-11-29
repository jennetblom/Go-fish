package com.example.gofish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

         lateinit var recyclerView1 : RecyclerView
         lateinit var recyclerView2: RecyclerView
         lateinit var carddeck: Carddeck

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val roundImage = findViewById<ImageView>(R.id.roundOceanImage)
        roundImage.setImageResource(R.drawable.roundocean)

        carddeck = Carddeck()
        carddeck.iniatializeCards()

        recyclerView1 = findViewById<RecyclerView>(R.id.recyclerView1)
        recyclerView2 = findViewById<RecyclerView>(R.id.recyclerView2)


        val handCardAdapter= CardAdapter(this,carddeck.cardDeck)
        recyclerView1.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView1.adapter = handCardAdapter
        recyclerView2.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView2.adapter=handCardAdapter
    }
}