package com.example.gofish

class Card( val suit:String , val value:Int, var isFaceUp: Boolean = false, val faceUpImage:Int, val faceDownImage:Int) {


    fun flipCard() {
        isFaceUp = !isFaceUp
    }
}