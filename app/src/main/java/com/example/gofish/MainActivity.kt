package com.example.gofish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {


    var carddeck = Carddeck()
    lateinit var recyclerView1: RecyclerView
    lateinit var recyclerView2: RecyclerView

    val player1 = Human("Jennet")
    val player2 = Computer("John")
    lateinit var seaCard1 : ImageView
    lateinit var seaCard2 : ImageView
    lateinit var seaCard3 : ImageView
    lateinit var seaCard4 : ImageView
    lateinit var seaCard5 : ImageView
    lateinit var seaCard6 : ImageView
    lateinit var seaCard7 : ImageView
    lateinit var seaCard8 : ImageView
    lateinit var seaCard9 : ImageView
    lateinit var seaCard10 : ImageView





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        seaCard1 = findViewById(R.id.seaCard1)
         seaCard2 = findViewById(R.id.seaCard2)
         seaCard3 = findViewById(R.id.seaCard3)
         seaCard4 = findViewById(R.id.seaCard4)
         seaCard5 = findViewById(R.id.seaCard5)
         seaCard6 = findViewById(R.id.seaCard6)
         seaCard7 = findViewById(R.id.seaCard7)
         seaCard8 = findViewById(R.id.seaCard8)
         seaCard9 = findViewById(R.id.seaCard9)
         seaCard10 = findViewById(R.id.seaCard10)


        val roundImage = findViewById<ImageView>(R.id.roundOceanImage)
        roundImage.setImageResource(R.drawable.roundocean)

        carddeck.shuffleDeck()

        val players = listOf(player1,player2)
        carddeck.dealCardsToPlayers(players)
        carddeck.dealCardsToPlayers(players)
        carddeck.dealCardsToPlayers(players)



       Log.d("!!!", player1.hand.size.toString())
        Log.d("!!!",carddeck.cardpile.size.toString())



        val cardAdapter1 = CardAdapter(this, player1.hand)
        val cardAdapter2= CardAdapter(this, player2.hand)




         recyclerView1 = findViewById(R.id.recyclerView1)
         recyclerView2 = findViewById(R.id.recyclerView2)




        recyclerView1.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView2.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)


        recyclerView1.adapter = cardAdapter1
        recyclerView2.adapter = cardAdapter2




        addPlayer1Fragment()
        addPlayer2Fragment()






        for(card in player1.hand){
            card.flipCard()
        }

        placeCardsInSea()





    }
    fun addPlayer1Fragment(){

        val player1Fragment = Player1Fragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.containerPlayer1,player1Fragment, "player1Fragment")
        transaction.commit()
    }
    fun addPlayer2Fragment(){

        val player2Fragment = Player2Fragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.containerPlayer2,player2Fragment, "player2Fragment")
        transaction.commit()
    }
    fun placeCardsInSea() {
        seaCard1.setImageResource(carddeck.cardpile.get(0).faceDownImage)
        seaCard2.setImageResource(carddeck.cardpile.get(1).faceDownImage)
        seaCard3.setImageResource(carddeck.cardpile.get(2).faceDownImage)
        seaCard4.setImageResource(carddeck.cardpile.get(3).faceDownImage)
        seaCard5.setImageResource(carddeck.cardpile.get(4).faceDownImage)
        seaCard6.setImageResource(carddeck.cardpile.get(5).faceDownImage)
        seaCard7.setImageResource(carddeck.cardpile.get(6).faceDownImage)
        seaCard8.setImageResource(carddeck.cardpile.get(7).faceDownImage)
        seaCard9.setImageResource(carddeck.cardpile.get(8).faceDownImage)
        seaCard10.setImageResource(carddeck.cardpile.get(9).faceDownImage)


    }





}
