package com.example.gofish

import java.util.Random


class Computer(name: String) : Player(name) {

}
fun selectCardToChoose(carddeck: Carddeck):Card?{
    if(carddeck.cardpile.isEmpty())
    {
        return null
    }

    val random = Random()
    val randomCardIndex = random.nextInt(carddeck.cardpile.size)
    val selectedCard = carddeck.cardpile[randomCardIndex]
    return selectedCard
}

