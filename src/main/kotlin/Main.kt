fun main() {
    val deck = Deck()
    val dealer = Dealer(deck)
    val player = Player("Carter")
    val game = Game(dealer, player)
    game.startGame()
}