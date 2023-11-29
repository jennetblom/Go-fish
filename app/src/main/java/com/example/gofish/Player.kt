package com.example.gofish

class Player (val name:String, private val carddeck: Carddeck){
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

}