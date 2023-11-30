package com.example.gofish

class Carddeck {
    var cardpile = mutableListOf<Card>()

    init {
        iniatializeCards()
        shuffleDeck()
    }
    fun shuffleDeck(){
        cardpile.shuffle()
    }

    fun dealCardsToPlayers(players:List<Player>){
        repeat(4){
            for(player in players){
                val card = drawCard()
                player.addCardToHand(card)
            }
        }
    }
    fun drawCard(): Card{

        if(cardpile.isEmpty()){

        }
        return cardpile.removeAt(0)
    }

    fun iniatializeCards(){
        cardpile.add(Card("Hearts",1,false,R.drawable.hearts_1, R.drawable.facedown))
        cardpile.add(Card("Hearts",2,false,R.drawable.hearts_2, R.drawable.facedown))
        cardpile.add(Card("Hearts",3,false , R.drawable.hearts_3, R.drawable.facedown))
        cardpile.add(Card("Hearts",4,false,R.drawable.hearts_4, R.drawable.facedown))
        cardpile.add(Card("Hearts",5,false,R.drawable.hearts_5, R.drawable.facedown))
        cardpile.add(Card("Hearts",6,false,R.drawable.hearts_6, R.drawable.facedown))
        cardpile.add(Card("Hearts",7,false,R.drawable.hearts_7, R.drawable.facedown))
        cardpile.add(Card("Hearts",8,false,R.drawable.hearts_8, R.drawable.facedown))
        cardpile.add(Card("Hearts",9,false,R.drawable.hearts_9, R.drawable.facedown))
        cardpile.add(Card("Hearts",10,false,R.drawable.hearts_10, R.drawable.facedown))
        cardpile.add(Card("Hearts",11,false,R.drawable.hearts_11, R.drawable.facedown))
        cardpile.add(Card("Hearts",12,false,R.drawable.hearts_12, R.drawable.facedown))
        cardpile.add(Card("Hearts",13,false,R.drawable.hearts_13, R.drawable.facedown))

        cardpile.add(Card("Spades",1,false,R.drawable.spades_1, R.drawable.facedown))
        cardpile.add(Card("Spades",2,false,R.drawable.spades_2, R.drawable.facedown))
        cardpile.add(Card("Spades",3,false,R.drawable.spades_3, R.drawable.facedown))
        cardpile.add(Card("Spades",4,false,R.drawable.spades_4, R.drawable.facedown))
        cardpile.add(Card("Spades",5,false,R.drawable.spades_5, R.drawable.facedown))
        cardpile.add(Card("Spades",6,false,R.drawable.spades_6, R.drawable.facedown))
        cardpile.add(Card("Spades",7,false,R.drawable.spades_7, R.drawable.facedown))
        cardpile.add(Card("Spades",8,false,R.drawable.spades_8, R.drawable.facedown))
        cardpile.add(Card("Spades",9,false,R.drawable.spades_9, R.drawable.facedown))
        cardpile.add(Card("Spades",10,false,R.drawable.spades_10, R.drawable.facedown))
        cardpile.add(Card("Spades",11,false,R.drawable.spades_11, R.drawable.facedown))
        cardpile.add(Card("Spades",12,false,R.drawable.spades_12, R.drawable.facedown))
        cardpile.add(Card("Spades",13,false,R.drawable.spades_13, R.drawable.facedown))

        cardpile.add(Card("Diamonds",1,false,R.drawable.diamonds_1, R.drawable.facedown))
        cardpile.add(Card("Diamonds",2,false,R.drawable.diamonds_2, R.drawable.facedown))
        cardpile.add(Card("Diamonds",3,false,R.drawable.diamonds_3, R.drawable.facedown))
        cardpile.add(Card("Diamonds",4,false,R.drawable.diamonds_4, R.drawable.facedown))
        cardpile.add(Card("Diamonds",5,false,R.drawable.diamonds_5, R.drawable.facedown))
        cardpile.add(Card("Diamonds",6,false,R.drawable.diamonds_6,R.drawable.facedown))
        cardpile.add(Card("Diamonds",7,false,R.drawable.diamonds_7,R.drawable.facedown))
        cardpile.add(Card("Diamonds",8,false,R.drawable.diamonds_8,R.drawable.facedown))
        cardpile.add(Card("Diamonds",9,false,R.drawable.diamonds_9,R.drawable.facedown))
        cardpile.add(Card("Diamonds",10,false,R.drawable.diamonds_10,R.drawable.facedown))
        cardpile.add(Card("Diamonds",11,false,R.drawable.diamonds_11,R.drawable.facedown))
        cardpile.add(Card("Diamonds",12,false,R.drawable.diamonds_12,R.drawable.facedown))
        cardpile.add(Card("Diamonds",13,false,R.drawable.diamonds_13,R.drawable.facedown))


        cardpile.add(Card("Clubs",1,false,R.drawable.clubs_1,R.drawable.facedown))
        cardpile.add(Card("Clubs",2,false,R.drawable.clubs_2,R.drawable.facedown))
        cardpile.add(Card("Clubs",3,false,R.drawable.clubs_3,R.drawable.facedown))
        cardpile.add(Card("Clubs",4,false,R.drawable.clubs_4,R.drawable.facedown))
        cardpile.add(Card("Clubs",5,false,R.drawable.clubs_5,R.drawable.facedown))
        cardpile.add(Card("Clubs",6,false,R.drawable.clubs_6,R.drawable.facedown))
        cardpile.add(Card("Clubs",7,false,R.drawable.clubs_7,R.drawable.facedown))
        cardpile.add(Card("Clubs",8,false,R.drawable.clubs_8,R.drawable.facedown))
        cardpile.add(Card("Clubs",9,false,R.drawable.clubs_9,R.drawable.facedown))
        cardpile.add(Card("Clubs",10,false,R.drawable.clubs_10,R.drawable.facedown))
        cardpile.add(Card("Clubs",11,false,R.drawable.clubs_11,R.drawable.facedown))
        cardpile.add(Card("Clubs",12,false,R.drawable.clubs_12,R.drawable.facedown))
        cardpile.add(Card("Clubs",13,false,R.drawable.clubs_13,R.drawable.facedown))

    }
}