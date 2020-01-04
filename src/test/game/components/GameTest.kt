package game.components

import game.rules.YahtzeeRules

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class GameAndPlayersTest {

    val game = Game(YahtzeeRules(), listOf("Alan", "Vicky", "Mark", "Darragh"))

    @Test
    fun initGame() {
        // Game is actually initialised when class is instantiated, so we just check its state here.
        assertEquals(4, game.numPlayers)
        assertEquals(listOf("Alan", "Vicky", "Mark", "Darragh"), game.playerNames)
    }

    @Test
    fun addPlayer() {
        game.addPlayer("John")
        assertEquals(5, game.numPlayers)
        assertEquals(listOf("Alan", "Vicky", "Mark", "Darragh", "John"), game.playerNames)
        game.startGame()
        assertThrows(GameInProgressError::class.java) {game.addPlayer("Derek")}
    }
    
}