package game.rules

import game.components.Dice
import game.components.ScoreCard
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class YatzyRulesTest {
    
    val rules = YatzyRules()
    val scoreCard = ScoreCard(rules)

    @Test
    fun onePair() {
        val dice = Dice(initVals=listOf(1, 2, 5, 4, 4))
        assertEquals(1, rules.calculateScore(dice, CommonUpperCategory.ONES))
        assertEquals(2, rules.calculateScore(dice, CommonUpperCategory.TWOS))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.THREES))
        assertEquals(8, rules.calculateScore(dice, CommonUpperCategory.FOURS))
        assertEquals(5, rules.calculateScore(dice, CommonUpperCategory.FIVES))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.SIXES))
        assertEquals(8, rules.calculateScore(dice, YatzyLowerCategory.ONE_PAIR))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.TWO_PAIR))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.THREE_KIND))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.FOUR_KIND))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.FULL_HOUSE))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.SMALL_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.LARGE_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.YATZY))
        assertEquals(16, rules.calculateScore(dice, YatzyLowerCategory.CHANCE))
        scoreCard.setScore(YatzyLowerCategory.ONE_PAIR, dice)
    }

    @Test
    fun twoPair() {
        val dice = Dice(initVals=listOf(2, 2, 5, 4, 4))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.ONES))
        assertEquals(4, rules.calculateScore(dice, CommonUpperCategory.TWOS))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.THREES))
        assertEquals(8, rules.calculateScore(dice, CommonUpperCategory.FOURS))
        assertEquals(5, rules.calculateScore(dice, CommonUpperCategory.FIVES))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.SIXES))
        assertEquals(8, rules.calculateScore(dice, YatzyLowerCategory.ONE_PAIR))
        assertEquals(12, rules.calculateScore(dice, YatzyLowerCategory.TWO_PAIR))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.THREE_KIND))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.FOUR_KIND))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.FULL_HOUSE))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.SMALL_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.LARGE_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.YATZY))
        assertEquals(17, rules.calculateScore(dice, YatzyLowerCategory.CHANCE))
        scoreCard.setScore(YatzyLowerCategory.TWO_PAIR, dice)
    }

    @Test
    fun threeKind() {
        val dice = Dice(initVals=listOf(4, 2, 5, 4, 4))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.ONES))
        assertEquals(2, rules.calculateScore(dice, CommonUpperCategory.TWOS))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.THREES))
        assertEquals(12, rules.calculateScore(dice, CommonUpperCategory.FOURS))
        assertEquals(5, rules.calculateScore(dice, CommonUpperCategory.FIVES))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.SIXES))
        assertEquals(8, rules.calculateScore(dice, YatzyLowerCategory.ONE_PAIR))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.TWO_PAIR))
        assertEquals(12, rules.calculateScore(dice, YatzyLowerCategory.THREE_KIND))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.FOUR_KIND))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.FULL_HOUSE))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.SMALL_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.LARGE_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.YATZY))
        assertEquals(19, rules.calculateScore(dice, YatzyLowerCategory.CHANCE))
        scoreCard.setScore(YatzyLowerCategory.THREE_KIND, dice)
    }

    @Test
    fun fourKind() {
        val dice = Dice(initVals=listOf(4, 4, 5, 4, 4))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.ONES))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.TWOS))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.THREES))
        assertEquals(16, rules.calculateScore(dice, CommonUpperCategory.FOURS))
        assertEquals(5, rules.calculateScore(dice, CommonUpperCategory.FIVES))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.SIXES))
        assertEquals(8, rules.calculateScore(dice, YatzyLowerCategory.ONE_PAIR))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.TWO_PAIR))
        assertEquals(12, rules.calculateScore(dice, YatzyLowerCategory.THREE_KIND))
        assertEquals(16, rules.calculateScore(dice, YatzyLowerCategory.FOUR_KIND))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.FULL_HOUSE))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.SMALL_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.LARGE_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.YATZY))
        assertEquals(21, rules.calculateScore(dice, YatzyLowerCategory.CHANCE))
        scoreCard.setScore(YatzyLowerCategory.FOUR_KIND, dice)
    }

    @Test
    fun fullHouse() {
        val dice = Dice(initVals=listOf(4, 5, 5, 4, 4))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.ONES))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.TWOS))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.THREES))
        assertEquals(12, rules.calculateScore(dice, CommonUpperCategory.FOURS))
        assertEquals(10, rules.calculateScore(dice, CommonUpperCategory.FIVES))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.SIXES))
        assertEquals(10, rules.calculateScore(dice, YatzyLowerCategory.ONE_PAIR))
        assertEquals(18, rules.calculateScore(dice, YatzyLowerCategory.TWO_PAIR))
        assertEquals(12, rules.calculateScore(dice, YatzyLowerCategory.THREE_KIND))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.FOUR_KIND))
        assertEquals(22, rules.calculateScore(dice, YatzyLowerCategory.FULL_HOUSE))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.SMALL_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.LARGE_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.YATZY))
        assertEquals(22, rules.calculateScore(dice, YatzyLowerCategory.CHANCE))
        scoreCard.setScore(YatzyLowerCategory.FULL_HOUSE, dice)
    }

    @Test
    fun smallStraight() {
        val dice = Dice(initVals=listOf(3, 5, 4, 2, 1))
        assertEquals(1, rules.calculateScore(dice, CommonUpperCategory.ONES))
        assertEquals(2, rules.calculateScore(dice, CommonUpperCategory.TWOS))
        assertEquals(3, rules.calculateScore(dice, CommonUpperCategory.THREES))
        assertEquals(4, rules.calculateScore(dice, CommonUpperCategory.FOURS))
        assertEquals(5, rules.calculateScore(dice, CommonUpperCategory.FIVES))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.SIXES))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.ONE_PAIR))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.TWO_PAIR))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.THREE_KIND))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.FOUR_KIND))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.FULL_HOUSE))
        assertEquals(15, rules.calculateScore(dice, YatzyLowerCategory.SMALL_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.LARGE_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.YATZY))
        assertEquals(15, rules.calculateScore(dice, YatzyLowerCategory.CHANCE))
        scoreCard.setScore(YatzyLowerCategory.SMALL_STRAIGHT, dice)
    }

    @Test
    fun largeStraight() {
        val dice = Dice(initVals=listOf(3, 5, 4, 6, 2))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.ONES))
        assertEquals(2, rules.calculateScore(dice, CommonUpperCategory.TWOS))
        assertEquals(3, rules.calculateScore(dice, CommonUpperCategory.THREES))
        assertEquals(4, rules.calculateScore(dice, CommonUpperCategory.FOURS))
        assertEquals(5, rules.calculateScore(dice, CommonUpperCategory.FIVES))
        assertEquals(6, rules.calculateScore(dice, CommonUpperCategory.SIXES))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.ONE_PAIR))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.TWO_PAIR))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.THREE_KIND))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.FOUR_KIND))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.FULL_HOUSE))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.SMALL_STRAIGHT))
        assertEquals(20, rules.calculateScore(dice, YatzyLowerCategory.LARGE_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.YATZY))
        assertEquals(20, rules.calculateScore(dice, YatzyLowerCategory.CHANCE))
        scoreCard.setScore(YatzyLowerCategory.LARGE_STRAIGHT, dice)
    }

    @Test
    fun yatzy() {
        val dice = Dice(initVals=listOf(4, 4, 4, 4, 4))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.ONES))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.TWOS))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.THREES))
        assertEquals(20, rules.calculateScore(dice, CommonUpperCategory.FOURS))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.FIVES))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.SIXES))
        assertEquals(8, rules.calculateScore(dice, YatzyLowerCategory.ONE_PAIR))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.TWO_PAIR))
        assertEquals(12, rules.calculateScore(dice, YatzyLowerCategory.THREE_KIND))
        assertEquals(16, rules.calculateScore(dice, YatzyLowerCategory.FOUR_KIND))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.FULL_HOUSE))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.SMALL_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YatzyLowerCategory.LARGE_STRAIGHT))
        assertEquals(50, rules.calculateScore(dice, YatzyLowerCategory.YATZY))
        assertEquals(20, rules.calculateScore(dice, YatzyLowerCategory.CHANCE))
        scoreCard.setScore(YatzyLowerCategory.YATZY, dice)
    }

    @Test
    fun calculateScoreWithInvalidCategory() {
        val dice = Dice(initVals=listOf(1, 2, 3, 2, 3))
        assertThrows(InvalidCategoryError::class.java) {rules.calculateScore(dice, BadCategory.BAD_CATEGORY)}
    }
    
}