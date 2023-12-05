package com.example.gofish

import android.util.Log

class Carddeck {
    var cardpile = mutableListOf<Card>()

    init {
        initializeCards()
        shuffleDeck()
    }

    fun shuffleDeck() {
        cardpile.shuffle()
    }

    fun dealCardsToPlayers(players: List<Player>) {
        repeat(4) {
            for (player in players) {
                val card = drawCard()
                player.addCardToHand(card)
            }
        }
    }

    fun drawCard(): Card {

        if (cardpile.isEmpty()) {

        }
        return cardpile.removeAt(0)
    }

    fun countPars(): Int {
        var pairs = 0
        for (card1 in 0 until cardpile.size) {
            for (card2 in card1 + 1 until cardpile.size) {
                if (cardpile[card1].value == cardpile[card2].value)
                    pairs++
            }
        }
        return pairs
    }

    fun fillPlayerHand(player: Player) {

        var numberOfCards:Int = 4
        while (cardpile.isNotEmpty() && player.hand.size < numberOfCards) {
            val card = cardpile.removeAt(0)
            player.hand.add(card)
            card.flipCardUp()
        }
    }
        fun findAndRemovePairs(player: Player): List<Pair<Card, Card>> {
//        val pairs = mutableListOf<Pair<Card,Card>>()
//        val toRemove = mutableListOf<Card>()
//        for(card1 in 0 until player.hand.size){
//            for(card2 in card1+1 until player.hand.size){
//                if(player.hand[card1].value==player.hand[card2].value){
//                    pairs.add(Pair(player.hand[card1],player.hand[card2]))
//                    toRemove.add(player.hand[card1])
//                    toRemove.add(player.hand[card2])
//                    player.score++
//                }
//            }
//        }
//        player.hand.removeAll(toRemove)
//        return pairs

            val pairs = mutableListOf<Pair<Card, Card>>()
            val uniqueHand = player.hand.distinct()
            val toRemove = mutableListOf<Card>()
            for (card1 in 0 until uniqueHand.size) {
                for (card2 in card1 + 1 until uniqueHand.size) {
                    if (uniqueHand[card1].value == uniqueHand[card2].value) {
                        pairs.add(Pair(uniqueHand[card1], uniqueHand[card2]))
                        toRemove.add(uniqueHand[card1])
                        toRemove.add(uniqueHand[card2])
                        player.score++
                    }
                }
            }
            player.hand.removeAll(toRemove)
            return pairs
        }

        fun initializeCards() {
            cardpile.add(Card("Hearts", 1, false, R.drawable.hearts_1, R.drawable.facedown))
            cardpile.add(Card("Hearts", 2, false, R.drawable.hearts_2, R.drawable.facedown))
            cardpile.add(Card("Hearts", 3, false, R.drawable.hearts_3, R.drawable.facedown))
            cardpile.add(Card("Hearts", 4, false, R.drawable.hearts_4, R.drawable.facedown))
            cardpile.add(Card("Hearts", 5, false, R.drawable.hearts_5, R.drawable.facedown))
            cardpile.add(Card("Hearts", 6, false, R.drawable.hearts_6, R.drawable.facedown))
            cardpile.add(Card("Hearts", 7, false, R.drawable.hearts_7, R.drawable.facedown))
            cardpile.add(Card("Hearts", 8, false, R.drawable.hearts_8, R.drawable.facedown))
            cardpile.add(Card("Hearts", 9, false, R.drawable.hearts_9, R.drawable.facedown))
            cardpile.add(Card("Hearts", 10, false, R.drawable.hearts_10, R.drawable.facedown))
            cardpile.add(Card("Hearts", 11, false, R.drawable.hearts_11, R.drawable.facedown))
            cardpile.add(Card("Hearts", 12, false, R.drawable.hearts_12, R.drawable.facedown))
            cardpile.add(Card("Hearts", 13, false, R.drawable.hearts_13, R.drawable.facedown))

            cardpile.add(Card("Spades", 1, false, R.drawable.spades_1, R.drawable.facedown))
            cardpile.add(Card("Spades", 2, false, R.drawable.spades_2, R.drawable.facedown))
            cardpile.add(Card("Spades", 3, false, R.drawable.spades_3, R.drawable.facedown))
            cardpile.add(Card("Spades", 4, false, R.drawable.spades_4, R.drawable.facedown))
            cardpile.add(Card("Spades", 5, false, R.drawable.spades_5, R.drawable.facedown))
            cardpile.add(Card("Spades", 6, false, R.drawable.spades_6, R.drawable.facedown))
            cardpile.add(Card("Spades", 7, false, R.drawable.spades_7, R.drawable.facedown))
            cardpile.add(Card("Spades", 8, false, R.drawable.spades_8, R.drawable.facedown))
            cardpile.add(Card("Spades", 9, false, R.drawable.spades_9, R.drawable.facedown))
            cardpile.add(Card("Spades", 10, false, R.drawable.spades_10, R.drawable.facedown))
            cardpile.add(Card("Spades", 11, false, R.drawable.spades_11, R.drawable.facedown))
            cardpile.add(Card("Spades", 12, false, R.drawable.spades_12, R.drawable.facedown))
            cardpile.add(Card("Spades", 13, false, R.drawable.spades_13, R.drawable.facedown))

            cardpile.add(Card("Diamonds", 1, false, R.drawable.diamonds_1, R.drawable.facedown))
            cardpile.add(Card("Diamonds", 2, false, R.drawable.diamonds_2, R.drawable.facedown))
            cardpile.add(Card("Diamonds", 3, false, R.drawable.diamonds_3, R.drawable.facedown))
            cardpile.add(Card("Diamonds", 4, false, R.drawable.diamonds_4, R.drawable.facedown))
            cardpile.add(Card("Diamonds", 5, false, R.drawable.diamonds_5, R.drawable.facedown))
            cardpile.add(Card("Diamonds", 6, false, R.drawable.diamonds_6, R.drawable.facedown))
            cardpile.add(Card("Diamonds", 7, false, R.drawable.diamonds_7, R.drawable.facedown))
            cardpile.add(Card("Diamonds", 8, false, R.drawable.diamonds_8, R.drawable.facedown))
            cardpile.add(Card("Diamonds", 9, false, R.drawable.diamonds_9, R.drawable.facedown))
            cardpile.add(Card("Diamonds", 10, false, R.drawable.diamonds_10, R.drawable.facedown))
            cardpile.add(Card("Diamonds", 11, false, R.drawable.diamonds_11, R.drawable.facedown))
            cardpile.add(Card("Diamonds", 12, false, R.drawable.diamonds_12, R.drawable.facedown))
            cardpile.add(Card("Diamonds", 13, false, R.drawable.diamonds_13, R.drawable.facedown))


            cardpile.add(Card("Clubs", 1, false, R.drawable.clubs_1, R.drawable.facedown))
            cardpile.add(Card("Clubs", 2, false, R.drawable.clubs_2, R.drawable.facedown))
            cardpile.add(Card("Clubs", 3, false, R.drawable.clubs_3, R.drawable.facedown))
            cardpile.add(Card("Clubs", 4, false, R.drawable.clubs_4, R.drawable.facedown))
            cardpile.add(Card("Clubs", 5, false, R.drawable.clubs_5, R.drawable.facedown))
            cardpile.add(Card("Clubs", 6, false, R.drawable.clubs_6, R.drawable.facedown))
            cardpile.add(Card("Clubs", 7, false, R.drawable.clubs_7, R.drawable.facedown))
            cardpile.add(Card("Clubs", 8, false, R.drawable.clubs_8, R.drawable.facedown))
            cardpile.add(Card("Clubs", 9, false, R.drawable.clubs_9, R.drawable.facedown))
            cardpile.add(Card("Clubs", 10, false, R.drawable.clubs_10, R.drawable.facedown))
            cardpile.add(Card("Clubs", 11, false, R.drawable.clubs_11, R.drawable.facedown))
            cardpile.add(Card("Clubs", 12, false, R.drawable.clubs_12, R.drawable.facedown))
            cardpile.add(Card("Clubs", 13, false, R.drawable.clubs_13, R.drawable.facedown))

        }
    }
