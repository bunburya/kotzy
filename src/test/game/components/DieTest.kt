package game.components

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DieTest {

    @Test
    fun initWithDefaultValues() {
        val d = Die()
        val value = d.value
        val max = d.maxValue
        assertEquals(6, max)
        assertTrue(value >= 1)
        assertTrue(value <= max)
    }

    @Test
    fun initWithCustomInitialValue() {
        assertThrows(DieError::class.java) {Die(7)}
        val initVal = 4
        val d = Die(initVal)
        assertEquals(initVal, d.value)
        assertEquals(6, d.maxValue)
    }

    @Test
    fun initWithCustomValues() {
        assertThrows(DieError::class.java) {Die(5, 3)}
        val initVal = 9
        val maxVal = 12
        val d = Die(initVal, maxVal)
        assertEquals(initVal, d.value)
        assertEquals(maxVal, d.maxValue)
    }

    @Test
    fun roll() {
        val numTests = 10000
        val values: HashMap<Int, Int> = hashMapOf()
        val d = Die()
        for (i in 1..d.maxValue) values[i] = 0
        repeat(numTests) {
            d.roll()
            val v = d.value
            values[v] = values[v]!!+1
        }
        val expectedCount = numTests/d.maxValue
        for (i in 1..d.maxValue) {
            val count = values[i]!!
            val diff = if (expectedCount > count) expectedCount - count else count - expectedCount
            assertTrue((diff.toDouble()/expectedCount) <= 0.1)
        }
    }

    @Test
    fun maxValue() {
        val numTests = 1000
        val d = Die()
        val max = d.maxValue
        repeat(numTests) {
            d.roll()
            assertTrue(d.value <= max)
        }
    }

}