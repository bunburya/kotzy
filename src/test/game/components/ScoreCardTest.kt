package game.components

import game.rules.YahtzeeRules

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class ScoreCardTest {

    var rules = YahtzeeRules()
    var sc = ScoreCard(rules)
    var categories = rules.categories

    @BeforeEach
    fun setUp() {
        var rules = YahtzeeRules()
        var sc = ScoreCard(rules)
        var categories = rules.categories
    }

    @Test
    fun setScoreWithInt() {
        val c = categories[categories.size-1]
        val score = 20
        sc.setScore(c, score)
        assertEquals(score, sc.getScore(c))
        assertEquals(score, sc.totalScore)
        assertThrows(AlreadyScoredError::class.java) {sc.setScore(c, score)}
        assertThrows(AlreadyScoredError::class.java) {sc.setScore(c, score*2)}
        assertEquals(score, sc.getScore(c))
        assertEquals(score, sc.totalScore)
    }

    @Test
    fun setSameScoreTwice() {
        val c = categories[categories.size-1]
        val score = 20
        sc.setScore(c, score)
        assertThrows(AlreadyScoredError::class.java) {sc.setScore(c, score)}
    }

    @Test
    fun setAllScoresWithUpperBonus() {
        val lowerScore = 20
        for (c in rules.upperCategories) {
            val s = (c.ordinal+1)*3
            sc.setScore(c, s)
        }
        for (c in rules.lowerCategories) sc.setScore(c, lowerScore)
        val expectedUpperTotal = rules.upperCategories.sumBy{ (it.ordinal+1)*3 }
        val expectedLowerTotal = lowerScore * rules.lowerCategories.size
        val expectedTotal = expectedUpperTotal + expectedLowerTotal + 35 // 35 for upper bonus
        assertEquals(expectedUpperTotal, sc.totalUpperScore)
        assertEquals(expectedLowerTotal, sc.totalLowerScore)
        assertEquals(expectedTotal, sc.totalScore)
    }

    @Test
    fun setAllScoresWithoutUpperBonus() {
        val lowerScore = 20
        for (c in rules.upperCategories) {
            sc.setScore(c, c.ordinal)
        }
        for (c in rules.lowerCategories) sc.setScore(c, lowerScore)
        val expectedUpperTotal = rules.upperCategories.sumBy{ it.ordinal }
        val expectedLowerTotal = lowerScore * rules.lowerCategories.size
        val expectedTotal = expectedUpperTotal + expectedLowerTotal // no upper bonus
        assertEquals(expectedTotal, sc.totalScore)
    }

    @Test
    fun getScore() {
        val c = categories[categories.size-1]
        val score = 20
        assertEquals(null, sc.getScore(c))
        sc.setScore(c, score)
        assertEquals(score, sc.getScore(c))
    }

}