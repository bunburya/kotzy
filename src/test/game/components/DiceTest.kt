package game.components

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DiceTest {

    @Test
    fun initWithDefaultValues() {
        val dice = Dice()
        assertEquals(5, dice.size)
        assertEquals(1, dice.values[0])
        assertEquals(2, dice.values[1])
        assertEquals(3, dice.values[2])
        assertEquals(4, dice.values[3])
        assertEquals(5, dice.values[4])
        assertEquals(6, dice[0].maxValue)
        assertEquals(6, dice[1].maxValue)
        assertEquals(6, dice[2].maxValue)
        assertEquals(6, dice[3].maxValue)
        assertEquals(6, dice[4].maxValue)
    }

    @Test
    fun initWithCustomNumDiceAndMax() {
        val max = 4
        val dice = Dice(3, max)
        assertEquals(1, dice.values[0])
        assertEquals(2, dice.values[1])
        assertEquals(3, dice.values[2])
        assertEquals(max, dice[0].maxValue)
        assertEquals(max, dice[1].maxValue)
        assertEquals(max, dice[2].maxValue)
    }

    @Test
    fun initWithCustomValues() {
        assertThrows(DiceError::class.java) {Dice(11, initVals = listOf(4, 7, 2, 6, 8, 7, 44, 10))}
        val dice = Dice(4, initVals = listOf(5, 1, 2, 3))
        assertEquals(5, dice.values[0])
        assertEquals(1, dice.values[1])
        assertEquals(2, dice.values[2])
        assertEquals(3, dice.values[3])
    }

    @Test
    fun getNumRolls() {
        val dice = Dice()
        dice.roll()
        assertEquals(1, dice.numRolls)
        dice.roll()
        assertEquals(2, dice.numRolls)
        dice.roll()
        assertEquals(3, dice.numRolls)
    }

    @Test
    fun hold() {
        val dice = Dice()
        dice.hold(listOf(0, 2, 4))
        val val0 = dice[0].value
        val val1 = dice[1].value
        val val2 = dice[2].value
        val val3 = dice[3].value
        val val4 = dice[4].value
        var othersChanged = false
        repeat(5) {
            dice.roll()
            assertEquals(val0, dice.values[0])
            assertEquals(val2, dice.values[2])
            assertEquals(val4, dice.values[4])
            if (dice.values[1] != val1 || dice.values[3] != val3) {
                othersChanged = true
            }
        }
        assertTrue(othersChanged)
    }
}