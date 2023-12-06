package com.example.gofish

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class GameActivity : AppCompatActivity() , CardClickListener  {


    lateinit var cardAdapter1: CardAdapter
    lateinit var cardAdapter2: CardAdapter
    var carddeck = Carddeck()
    lateinit var recyclerView1: RecyclerView
    lateinit var recyclerView2: RecyclerView
    val player1 = Human("Player 1")
    val player2 = Computer("Player 2")
    var currentPlayer: Player = player1
    var otherPlayer: Player = player2
    var computerCard : Card? = null

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
    lateinit var playerTurnTextView: TextView

    lateinit var chatBubble1: ImageView
    lateinit var chatBubble2: ImageView
    lateinit var chatBubbleText1: TextView
    lateinit var chatBubbleText2: TextView
    lateinit var goFishText: TextView
    lateinit var showCard1: ImageView

    lateinit var player1score: TextView
    lateinit var player2score : TextView
    lateinit var homeButton : Button
    lateinit var helpTextView: TextView
    lateinit var goFishButton: Button
    var askClickable : Boolean = true
    var giveClickable : Boolean = false
    var seaCardsClickable : Boolean = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        initializeViews()
        initializeGame()


    }
    fun initializeGame(){
//        var askClickable : Boolean = true
//        var giveClickable : Boolean = false
//        var seaCardsClickable : Boolean = false
        carddeck.shuffleDeck()
        val players = listOf(player1, player2)
        carddeck.dealCardsToPlayers(players)
        placeCardsInSea()
        player1score.text = player1.showScore()
        player2score.text = player2.showScore()

        for (card in player1.hand) {
            card.flipCardUp()
        }

        for (card in player2.hand) {
            card.flipCardUp()
        }
    }
    override fun onCardClick(card: Card) {

        if(currentPlayer==player1) {
            if (askClickable) {
                askPlayerForACard(card)
                askClickable = answerOtherPlayer(card)
            }
        }
        if(currentPlayer==player2) {
            if (giveClickable) {
                if(computerCard==null){
                    computerCard=computerPlayer2Turn()
                }
                helpTextView.text = "Click on a card to give"
                if (card.value == computerCard?.value) {
                    chatBubbleText1.text = "YES"
                    chatBubbleText2.text = "WOWOOHOOHO!"
                    hasCard(card)
                } else if (card.value!=computerCard?.value){
                    chatBubbleText1.textSize=10f
                    chatBubbleText1.text = "No, go fish"
                    helpTextView.text = "Click on the Go Fish-button"
                    goFishButtonClick()
                }

                giveClickable=false
            }
        }
    }
    fun goFishButtonClick(){

        goFishButton.isEnabled=true

        if(currentPlayer==player2){
        goFishButton.setOnClickListener {

            var card = carddeck.drawCard()
            player2.addCardToHand(card)
            card.flipCardUp()
            goFishButton.isEnabled = false
            goFishButton.visibility = View.GONE


            animateCardFromSea(card)


            Handler(Looper.getMainLooper()).postDelayed({
                // Code to be executed after 3 seconds
                updateRecyclerView()
                //giveClickable = false
                goFishText.visibility = View.GONE
                switchPlayers()
                chatBubbleText1.text=""
                chatBubbleText2.text=""

            }, 1600)

        }
            //switchPlayers()
        }
    }

    fun humanPlayer1turn(){
        chatBubbleText1.textSize = 10f
        askClickable=true
        seaCardsClickable=false
        helpTextView.text = "Choose the card you want to ask for"
    }
    fun computerPlayer2Turn():Card?{
        //player 2 väljer ett random kort som den frågar spelare 1 om
        val randomCard = player2.selectCardToChoose(player2.hand)
        chatBubbleText1.textSize = 24f
        chatBubbleText1.text = "..."


        if(randomCard!=null){
            askPlayerForACard(randomCard)
            helpTextView.text = "Click on a card to give or click the button"
            goFishButton.visibility = View.VISIBLE
            giveClickable = true
            goFishButtonClick()
            return randomCard
            //answerOtherPlayer(card)
        }
        return null
        //answerOtherPlayer(card)
    }
    fun fillPlayerHands(){
        val players = listOf(player1,player2)
        for(player in players ){
            carddeck.fillPlayerHand(player)

            for (card in player1.hand) {
                card.flipCardUp()
            }

            for (card in player2.hand) {
                card.flipCardUp()
            }
        }
    }

    fun ifGameIsOver() : Boolean {

        if(carddeck.cardpile.isEmpty()){
            updateScore()
            val winner = checkWhoIsWinner()
            helpTextView.text = "$winner wins!"

            homeButton.setOnClickListener {
                helpTextView.text = "$winner wins wohowhwowhoh"
            }
            return true
        }
        return false
    }
    fun checkWhoIsWinner():Player{

        if(player1.score>player2.score){
            return player1
        }
        else{
            return player2
        }
    }
    fun switchPlayers(){

        fillPlayerHands()
        ifGameIsOver()
        updateScore()

        if(currentPlayer==player1){
            currentPlayer=player2
           // computerCard=null
            computerPlayer2Turn()
            playerTurnTextView.text = "${currentPlayer.name}'s turn"
        }
        else{
            currentPlayer=player1
            humanPlayer1turn()
            computerCard=null
            playerTurnTextView.text = "${currentPlayer.name}'s turn"
        }
    }

    fun placeCardsInSea() {

        val seaCardViews = listOf(
            seaCard1,
            seaCard2,
            seaCard3,
            seaCard4,
            seaCard5,
            seaCard6,
            seaCard7,
            seaCard8,
            seaCard9,
            seaCard10
        )

        for (i in seaCardViews.indices) {
            if (i < carddeck.cardpile.size) {
                seaCardViews[i].setImageResource(carddeck.cardpile[i].faceDownImage)
            } else {
                seaCardViews[i].visibility = View.GONE
            }
        }
    }

    fun updateScore(){

        Handler(Looper.getMainLooper()).postDelayed({
            // Code to be executed after 3 seconds
            val players = listOf(player1,player2)
            for(player in players){
                carddeck.findAndRemovePairs(player)
                player.showScore()
            }
            player1score.text = player1.showScore()
            player2score.text = player2.showScore()
            updateRecyclerView()
        }, 2000)

    }
    fun giveCard(card : Card){
        player1.giveCard(player2,card)
    }

    fun askPlayerForACard(card: Card) {


        chatBubble1.setImageResource(R.drawable.chaticon4)
        chatBubble2.setImageResource(R.drawable.chaticon4)
        chatBubble1.visibility = View.VISIBLE
        chatBubble2.visibility = View.VISIBLE

        val askingPlayerText: TextView

        if (currentPlayer == player1) {
            askingPlayerText = chatBubbleText1
        } else {
            askingPlayerText = chatBubbleText2
        }
        askingPlayerText.text = "Do you have ${card.value}?"
        fillPlayerHands()
        ifGameIsOver()
    }
    fun answerOtherPlayer(card: Card) : Boolean {

        val answerPlayerText: TextView

        if (currentPlayer == player1) {
            answerPlayerText = chatBubbleText2
        } else {
            answerPlayerText = chatBubbleText1
        }

            val hasCard = otherPlayer.hand.any {
                it.value == card.value
            }

            if (hasCard) {
                answerPlayerText.text = "YES"
                hasCard(card)

            } else if(!hasCard){
                answerPlayerText.text = "No sorry! Go fish!"

                goFish()
            }
        return hasCard
        }


    fun updateRecyclerView() {
        cardAdapter1.notifyDataSetChanged()
        cardAdapter2.notifyDataSetChanged()
    }
    fun hasCard(clickedCard: Card){
        var givenCard = otherPlayer.giveCard(currentPlayer, clickedCard)
        if (givenCard != null) {
            animateGivenCard(givenCard)
        }

        Handler(Looper.getMainLooper()).postDelayed({
            // Code to be executed after 3 seconds
            updateRecyclerView()

            if(currentPlayer==player1){
                helpTextView.text = "Choose another card"
            }
        }, 1500)
    }
    fun animateGoFish() {

        val seaCardViews = listOf(
            seaCard1,
            seaCard2,
            seaCard3,
            seaCard4,
            seaCard5,
            seaCard6,
            seaCard7,
            seaCard8,
            seaCard9,
            seaCard10
        )

        for (seaCardView in seaCardViews) {

            val moveUpAnimator = ObjectAnimator.ofFloat(seaCardView, "translationY", -100f, 0f)
            moveUpAnimator.duration = 1000
            val moveDownAnimator = ObjectAnimator.ofFloat(seaCardView, "translationY", -0f, -50f)
            moveDownAnimator.duration = 1000
            val animatorSet = AnimatorSet()
            animatorSet.playSequentially(moveUpAnimator, moveDownAnimator)
            animatorSet.start()
        }
    }

    fun animateGivenCard(card: Card) {

        showCard1.visibility = View.VISIBLE
        if (currentPlayer == player1) {
            showCard1.setImageResource(card.faceUpImage)

            val moveDownAnimator = ObjectAnimator.ofFloat(showCard1, "translationY", -0f, 800f)
            val moveRightAnimator = ObjectAnimator.ofFloat(showCard1, "translationX", 0f, 350f)
            moveDownAnimator.duration = 1000
            val animatorSet = AnimatorSet()
            moveRightAnimator.duration = 1000
            animatorSet.playTogether(moveDownAnimator, moveRightAnimator)
            animatorSet.start()

            Handler(Looper.getMainLooper()).postDelayed({
                // Code to be executed after 3 seconds
                showCard1.visibility = View.GONE
            }, 1000)
        } else if (currentPlayer == player2) {

            showCard1.setImageResource(card.faceUpImage)
            val moveUpAnimator = ObjectAnimator.ofFloat(showCard1, "translationY", 800f, 0f)
            moveUpAnimator.duration = 1000
            val moveRightAnimator = ObjectAnimator.ofFloat(showCard1, "translationX", 0f, 350f)
            moveRightAnimator.duration = 1000
            val animatorSet = AnimatorSet()
            animatorSet.playTogether(moveUpAnimator, moveRightAnimator)
            animatorSet.start()
            Handler(Looper.getMainLooper()).postDelayed({
                // Code to be executed after 3 seconds
                showCard1.visibility = View.GONE
            }, 1000)
        }
    }

    fun goFish(){
        val seaCards = listOf(seaCard1,seaCard2,seaCard3,seaCard4, seaCard5,seaCard6,seaCard7,seaCard8,seaCard9,seaCard10)


        if(currentPlayer==player1) {
            helpTextView.text = "Click on a card in the sea"

            animateGoFish()
            seaCardsClickable = true
            //goFish()
            Handler(Looper.getMainLooper()).postDelayed({
                // Code to be executed after 3 seconds
                goFishText.visibility = View.VISIBLE
            }, 1500)

            if (seaCardsClickable) {
                seaCardsClickable = false

                for (seaCard in seaCards) {
                    seaCard.setOnClickListener {
                        for (card in seaCards) {
                            card.setOnClickListener(null)
                        }
                        var card = carddeck.drawCard()
                        currentPlayer.addCardToHand(card)
                        card.flipCardUp()

                        animateCardFromSea(card)

                        Handler(Looper.getMainLooper()).postDelayed({
                            // Code to be executed after 3 seconds
                            updateRecyclerView()
                            goFishText.visibility = View.GONE
                            switchPlayers()

                        }, 1600)
                    }

                }
            }
        }
    }
    fun animateCardFromSea(card : Card) {

        showCard1.visibility = View.VISIBLE
        showCard1.setImageResource(card.faceUpImage)

        if (currentPlayer == player1) {
            val moveDownAnimator = ObjectAnimator.ofFloat(showCard1, "translationY", 200f, 900f)
            val moveRightAnimator = ObjectAnimator.ofFloat(showCard1, "translationX", 0f, 350f)
            moveDownAnimator.duration = 1500
            val animatorSet = AnimatorSet()
            moveRightAnimator.duration = 1000
            animatorSet.playTogether(moveDownAnimator, moveRightAnimator)
            animatorSet.start()
            Handler(Looper.getMainLooper()).postDelayed({
                // Code to be executed after 3 seconds
                showCard1.visibility = View.GONE
                goFishText.visibility = View.GONE
            }, 1500)
        } else if (currentPlayer==player2) {
            val moveDownAnimator = ObjectAnimator.ofFloat(showCard1, "translationY", 400f, -100f)
            val moveRightAnimator = ObjectAnimator.ofFloat(showCard1, "translationX", 0f, 350f)
            moveDownAnimator.duration = 1500
            val animatorSet = AnimatorSet()
            moveRightAnimator.duration = 1000
            animatorSet.playTogether(moveDownAnimator, moveRightAnimator)
            animatorSet.start()
            Handler(Looper.getMainLooper()).postDelayed({
                // Code to be executed after 3 seconds
                showCard1.visibility = View.GONE
                goFishText.visibility = View.GONE
            }, 1500)
        }
    }
    fun initializeViews(){
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
        showCard1 = findViewById(R.id.showCard1)
        player1score = findViewById(R.id.player1score)
        player2score = findViewById(R.id.player2score)
        val roundImage = findViewById<ImageView>(R.id.roundOceanImage)
        roundImage.setImageResource(R.drawable.roundocean)
        cardAdapter1 = CardAdapter(this, player1.hand, this, true)
        cardAdapter2 = CardAdapter(this, player2.hand, this, false)
        recyclerView1 = findViewById(R.id.recyclerView1)
        recyclerView2 = findViewById(R.id.recyclerView2)
        chatBubble1 = findViewById<ImageView>(R.id.chatBubble1)
        chatBubble2 = findViewById<ImageView>(R.id.chatBubble2)
        chatBubble1.visibility = View.GONE
        chatBubble2.visibility = View.GONE
        chatBubbleText1 = findViewById<TextView>(R.id.player1textView)
        chatBubbleText2 = findViewById<TextView>(R.id.player2textView)
        recyclerView1.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView1.adapter = cardAdapter1
        recyclerView2.adapter = cardAdapter2
        homeButton = findViewById(R.id.homeButton)
        goFishButton = findViewById(R.id.gofishButton)
        helpTextView = findViewById(R.id.helpTextView)
        goFishButton.visibility = View.GONE
        playerTurnTextView = findViewById(R.id.playerTurnTextView)

        helpTextView.text = "Choose the card you want to ask for"
        playerTurnTextView.text = "${currentPlayer.name}'s turn"
    }
}





