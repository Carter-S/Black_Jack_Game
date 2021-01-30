class Player(val name: String) {
    var hand = mutableListOf<Card>()

    //players move
    fun playerMove(): String {
        printHand()
        return twistOrStick()
    }

    //player chooses to keep current cards or draw one more
    private fun twistOrStick(): String {
        var validAnswer = false
        var answer = ""
        while (!validAnswer) {
            println("Would you like to twist or stick?")
            answer = readLine().toString()
            if (answer == "twist" || answer == "stick" || answer == "quit") {
                validAnswer = true
            } else {
                println("Invalid answer, please enter \"twist\" or \"stick\".")
            }
        }
        return answer
    }

    //prints players hand
    private fun printHand() {
        println("Your cards are:")
        hand.forEach {
            println(it.value + " of " + it.suit)
        }
    }
}