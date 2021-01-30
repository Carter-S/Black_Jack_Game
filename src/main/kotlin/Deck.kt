class Deck{
    private val suits = listOf("Diamonds", "Hearts", "Spades", "Clubs")
    private val values = listOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
    val cards = mutableListOf<Card>()

    init{
        fillDeck()
        shuffleDeck()
    }

    //Populates deck with cards
    private fun fillDeck(){
        for(i in 0..3){
            for(j in 0..12){
                val card = Card(values[j], suits[i])
                cards.add(card)
            }
        }
    }

    //Shuffles deck
    private fun shuffleDeck(){
        cards.shuffle()
    }

}

class Card(val value: String, val suit: String);