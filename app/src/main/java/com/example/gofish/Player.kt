package com.example.gofish

import android.widget.TextView

open class Player (val name:String){
    var hand = mutableListOf<Card>()
    var score = 0


    fun addCardToHand(card: Card){
        hand.add(card)
    }
    fun removeCardFromHand(card:Card){
        hand.remove(card)
    }
    fun countPairsAndIncreaseScore(){
        val valuesCount = mutableMapOf<Int,Int>()
        for(card in hand){
            valuesCount[card.value]=valuesCount.getOrDefault(card.value,0)+1
        }

        for(count in valuesCount.values){
            score+=count/2
        }
    }
    fun giveCard(otherPlayer : Player, cardValue : Int){
        val card = hand.find { it.value == cardValue }
        if(card!=null){
            removeCardFromHand(card)
            otherPlayer.addCardToHand(card)
        }
    }
}