package com.example.gofish

import java.util.Random


class Computer(name: String) : Player(name) {

}
fun selectCardToChoose(cardList: List<Card>):Card?{

    if(cardList.isNotEmpty()) {
        val random = Random()
        val randomCardIndex = random.nextInt(cardList.size)
        return cardList[randomCardIndex]
    }
    return null

}