package com.example.gofish

import android.widget.TextView
import java.util.Random

open class Player (val name:String) {
    var hand = mutableListOf<Card>()
    var score = 0


    fun addCardToHand(card: Card) {
        hand.add(card)
    }

    fun removeCardFromHand(card: Card) {
        hand.remove(card)
    }

    fun giveCard(otherPlayer : Player, cardValue : Int): Card?{
        val card = hand.find { it.value == cardValue }
        if(card!=null){
            removeCardFromHand(card)
            otherPlayer.addCardToHand(card)
            return card
        }
        return null
    }
    fun showScore():String{
        return "Score : $score"
    }

    fun selectCardToChoose(cardList: List<Card>):Card?{

        if(cardList.isNotEmpty()) {
                val random = Random()
                val randomCardIndex = random.nextInt(cardList.size)
                return cardList[randomCardIndex]
    }
            return null

    }
}