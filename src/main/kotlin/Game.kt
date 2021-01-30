import kotlin.system.exitProcess

class Game(val dealer: Dealer, val player: Player) {
    var gameOver = false

    init {
        while (!gameOver) {
            println("Type \"quit\" to leave.")
            println("-------------------------------------------------------------------")
            for (i in 1..2) {
                dealer.dealCard(player)
                dealer.drawCard()
            }
            dealer.revealCard(0)
            var roundOver = false
            while (!roundOver) {
                var move = player.playerMove()
                if (move == "quit") {
                    exitProcess(1)
                } else if (move == "twist") {
                    dealer.dealCard(player)
                    if (isBust(player.hand)) {
                        roundOver = true
                    }
                } else {
                    while (getSum(player.hand) > getSum(dealer.hand)) {
                        dealer.drawCard()
                    }
                    roundOver = true
                }
            }
            if (isBust(player.hand) || ((getSum(player.hand) <= getSum(dealer.hand)) && !isBust(dealer.hand))) {
                println("You lost.")
                dealer.printHand()
            } else {
                println("You win, dealer went bust.")
                dealer.printHand()
            }
            dealer.clearHands(player)
        }
    }

    //check if a player is bust
    fun isBust(hand: MutableList<Card>): Boolean {
        return getSum(hand) > 21
    }

    //calculates total sum of cards in a hand
    fun getSum(hand: MutableList<Card>): Int {
        var sum = 0
        var hasAce = false
        hand.forEach {
            when (it.value) {
                "2" -> sum += 2
                "3" -> sum += 3
                "4" -> sum += 4
                "5" -> sum += 5
                "6" -> sum += 6
                "7" -> sum += 7
                "8" -> sum += 8
                "9" -> sum += 9
                "10" -> sum += 10
                "J" -> sum += 10
                "Q" -> sum += 10
                "K" -> sum += 10
                "A" -> hasAce = true
            }
        }
        if (hasAce) {
            if (sum <= 10) {
                sum += 11
            } else {
                sum += 1
            }
        }
        return sum
    }
}