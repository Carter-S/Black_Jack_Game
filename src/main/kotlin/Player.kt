import org.jetbrains.annotations.Nullable

class Player(val name: String){
    var hand = mutableListOf<Card>()

    fun playerMove(): String{
        printHand()
        return twistOrStick()
    }

    private fun twistOrStick(): String{
        var validAnswer = false
        var answer = ""
        while(!validAnswer) {
            println("Would you like to twist or stick?")
            answer = readLine().toString()
            if(answer == "twist" || answer == "stick" || answer == "quit"){
                validAnswer = true
            }else{
                println("Invalid answer, please enter \"twist\" or \"stick\".")
            }
        }
        return answer
    }

    private fun printHand(){
        println("Your cards are:")
        hand.forEach {
            println(it.value + " of " + it.suit)
        }
    }
}