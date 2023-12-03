package com.example.gofish

class Card( val suit:String , val value:Int, var isFaceUp: Boolean = false, val faceUpImage:Int, val faceDownImage:Int) {


    fun flipCardUp() {
        isFaceUp = true
    }
    fun flipCardDown() {
        isFaceUp = false
    }
}