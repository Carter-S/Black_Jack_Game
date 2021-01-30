class Dealer(private val deck: Deck){
    var hand = mutableListOf<Card>()

    fun dealCard(player: Player){
        val tmpCard = deck.cards[0]
        deck.cards.removeAt(0)
        player.hand.add(tmpCard)
    }

    fun drawCard(){
        val tmpCard = deck.cards[0]
        deck.cards.removeAt(0)
        hand.add(tmpCard)
    }

    fun clearHands(player : Player){
            hand.forEach {
                deck.cards.add(it)
            }
            player.hand.forEach {
                deck.cards.add(it)
            }
        hand.clear()
        player.hand.clear()
    }

    fun revealCard(pos: Int){
        println("Dealers first card: ")
        println(hand[pos].value + " of " + hand[pos].suit)
    }

    fun printHand(){
        println("Dealers cards: ")
        hand.forEach {
            println(it.value + " of " + it.suit)
        }
    }
}