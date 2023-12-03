package com.example.gofish

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() , CardClickListener {


    lateinit var cardAdapter1: CardAdapter
    lateinit var cardAdapter2: CardAdapter
    var carddeck = Carddeck()
    lateinit var recyclerView1: RecyclerView
    lateinit var recyclerView2: RecyclerView


    val player1 = Human("Human")
    val player2 = Computer("Computer")
    var currentPlayer : Player =  player1
    var otherPlayer : Player = player2
    lateinit var seaCard1: ImageView
    lateinit var seaCard2: ImageView
    lateinit var seaCard3: ImageView
    lateinit var seaCard4: ImageView
    lateinit var seaCard5: ImageView
    lateinit var seaCard6: ImageView
    lateinit var seaCard7: ImageView
    lateinit var seaCard8: ImageView
    lateinit var seaCard9: ImageView
    lateinit var seaCard10: ImageView

    lateinit var chatBubble1: ImageView
    lateinit var chatBubble2: ImageView
    lateinit var chatBubbleText1: TextView
    lateinit var chatBubbleText2: TextView
    lateinit var goFishText : TextView


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
        goFishText = findViewById(R.id.goFishTextView)
        goFishText.visibility = View.GONE


        val roundImage = findViewById<ImageView>(R.id.roundOceanImage)
        roundImage.setImageResource(R.drawable.roundocean)

        carddeck.shuffleDeck()

        val players = listOf(player1, player2)
        carddeck.dealCardsToPlayers(players)
        carddeck.dealCardsToPlayers(players)






        Log.d("!!!", player1.hand.size.toString())
        Log.d("!!!", carddeck.cardpile.size.toString())


         cardAdapter1 = CardAdapter(this, player1.hand, this, true)
         cardAdapter2 = CardAdapter(this, player2.hand, this, false)


        recyclerView1 = findViewById(R.id.recyclerView1)
        recyclerView2 = findViewById(R.id.recyclerView2)

        chatBubble1 = findViewById<ImageView>(R.id.chatBubble1)
        chatBubble2 = findViewById<ImageView>(R.id.chatBubble2)
        chatBubbleText1 = findViewById<TextView>(R.id.player1textView)
        chatBubbleText2 = findViewById<TextView>(R.id.player2textView)



        recyclerView1.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        recyclerView1.adapter = cardAdapter1
        recyclerView2.adapter = cardAdapter2



        addPlayer1Fragment()
        addPlayer2Fragment()


        for (card in player1.hand) {
            card.flipCardUp()
        }
        for (card in player2.hand) {
            card.flipCardUp()
        }

        placeCardsInSea()





    }


    fun addPlayer1Fragment() {

        val player1Fragment = Player1Fragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.containerPlayer1, player1Fragment, "player1Fragment")
        transaction.commit()
    }

    fun addPlayer2Fragment() {

        val player2Fragment = Player2Fragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.containerPlayer2, player2Fragment, "player2Fragment")
        transaction.commit()
    }

    fun placeCardsInSea() {

        val seaCardViews = listOf(
            seaCard1, seaCard2, seaCard3, seaCard4, seaCard5, seaCard6, seaCard7, seaCard8, seaCard9, seaCard10
        )

        for(i in seaCardViews.indices){
            if(i < carddeck.cardpile.size){
                seaCardViews[i].setImageResource(carddeck.cardpile[i].faceDownImage)
            }
            else{
                seaCardViews[i].visibility = View.GONE
            }
        }
    }

    override fun onCardClick(position: Int, cardValue : Int) {

       askOtherPlayer(cardValue)
    }
    fun askOtherPlayer(cardValue: Int){

        chatBubble1.setImageResource(R.drawable.chaticon4)
        chatBubble2.setImageResource(R.drawable.chaticon4)
        chatBubble1.visibility = View.VISIBLE
        chatBubble2.visibility = View.VISIBLE

        val askingPlayerText : TextView
        val otherPlayerText : TextView
        if(currentPlayer==player1){
            askingPlayerText = chatBubbleText1
            otherPlayerText = chatBubbleText2
        }else{
            askingPlayerText=chatBubbleText2
            otherPlayerText = chatBubbleText1
        }
        askingPlayerText.text = "Do you have $cardValue?"


        val hasCard = otherPlayer.hand.any{
            it.value == cardValue
        }
        if(hasCard){
            otherPlayerText.text = "YES"
            otherPlayer.giveCard(currentPlayer, cardValue)
            updateRecyclerView()
        }
        else{
            otherPlayerText.text = "No sorry! Go fish!"


            Handler(Looper.getMainLooper()).postDelayed({
                // Code to be executed after 3 seconds
                goFishText.visibility = View.VISIBLE
            }, 1500)
            animateCard()
        }
    }
    fun updateRecyclerView(){
        cardAdapter1.updateData(player1.hand)
        cardAdapter2.updateData(player2.hand)
    }
    fun animateCard(){

        val seaCardViews = listOf(
            seaCard1, seaCard2, seaCard3, seaCard4, seaCard5, seaCard6, seaCard7, seaCard8, seaCard9, seaCard10
        )

        for(seaCardView in seaCardViews){

            val moveUpAnimator = ObjectAnimator.ofFloat(seaCardView, "translationY", -50f,0f)
            moveUpAnimator.duration = 1000
            val moveDownAnimator = ObjectAnimator.ofFloat(seaCardView, "translationY",-0f,-150f)
            moveDownAnimator.duration = 1000
            val animatorSet = AnimatorSet()
            animatorSet.playSequentially(moveUpAnimator,moveDownAnimator)
            animatorSet.start()
        }
    }
}




