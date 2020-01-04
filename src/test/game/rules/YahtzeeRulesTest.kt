package game.rules

import game.components.*

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class YahtzeeRulesTest {

    val rules = YahtzeeRules()
    val scoreCard = ScoreCard(rules)

    @Test
    fun threeKind() {
        val dice = Dice(initVals=listOf(4, 2, 5, 4, 4))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.ONES))
        assertEquals(2, rules.calculateScore(dice, CommonUpperCategory.TWOS))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.THREES))
        assertEquals(12, rules.calculateScore(dice, CommonUpperCategory.FOURS))
        assertEquals(5, rules.calculateScore(dice, CommonUpperCategory.FIVES))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.SIXES))
        assertEquals(19, rules.calculateScore(dice, YahtzeeLowerCategory.THREE_KIND))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.FOUR_KIND))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.FULL_HOUSE))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.SHORT_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.LONG_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.FIVE_KIND))
        assertEquals(19, rules.calculateScore(dice, YahtzeeLowerCategory.CHANCE))
        scoreCard.setScore(YahtzeeLowerCategory.THREE_KIND, dice)
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
        assertEquals(21, rules.calculateScore(dice, YahtzeeLowerCategory.THREE_KIND))
        assertEquals(21, rules.calculateScore(dice, YahtzeeLowerCategory.FOUR_KIND))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.FULL_HOUSE))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.SHORT_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.LONG_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.FIVE_KIND))
        assertEquals(21, rules.calculateScore(dice, YahtzeeLowerCategory.CHANCE))
        scoreCard.setScore(YahtzeeLowerCategory.FOUR_KIND, dice)
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
        assertEquals(22, rules.calculateScore(dice, YahtzeeLowerCategory.THREE_KIND))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.FOUR_KIND))
        assertEquals(25, rules.calculateScore(dice, YahtzeeLowerCategory.FULL_HOUSE))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.SHORT_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.LONG_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.FIVE_KIND))
        assertEquals(22, rules.calculateScore(dice, YahtzeeLowerCategory.CHANCE))
        scoreCard.setScore(YahtzeeLowerCategory.FULL_HOUSE, dice)
    }

    @Test
    fun shortStraight() {
        val dice = Dice(initVals=listOf(3, 5, 4, 6, 1))
        assertEquals(1, rules.calculateScore(dice, CommonUpperCategory.ONES))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.TWOS))
        assertEquals(3, rules.calculateScore(dice, CommonUpperCategory.THREES))
        assertEquals(4, rules.calculateScore(dice, CommonUpperCategory.FOURS))
        assertEquals(5, rules.calculateScore(dice, CommonUpperCategory.FIVES))
        assertEquals(6, rules.calculateScore(dice, CommonUpperCategory.SIXES))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.THREE_KIND))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.FOUR_KIND))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.FULL_HOUSE))
        assertEquals(30, rules.calculateScore(dice, YahtzeeLowerCategory.SHORT_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.LONG_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.FIVE_KIND))
        assertEquals(19, rules.calculateScore(dice, YahtzeeLowerCategory.CHANCE))
        scoreCard.setScore(YahtzeeLowerCategory.SHORT_STRAIGHT, dice)
    }

    @Test
    fun longStraight() {
        val dice = Dice(initVals=listOf(3, 5, 4, 6, 2))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.ONES))
        assertEquals(2, rules.calculateScore(dice, CommonUpperCategory.TWOS))
        assertEquals(3, rules.calculateScore(dice, CommonUpperCategory.THREES))
        assertEquals(4, rules.calculateScore(dice, CommonUpperCategory.FOURS))
        assertEquals(5, rules.calculateScore(dice, CommonUpperCategory.FIVES))
        assertEquals(6, rules.calculateScore(dice, CommonUpperCategory.SIXES))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.THREE_KIND))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.FOUR_KIND))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.FULL_HOUSE))
        assertEquals(30, rules.calculateScore(dice, YahtzeeLowerCategory.SHORT_STRAIGHT))
        assertEquals(40, rules.calculateScore(dice, YahtzeeLowerCategory.LONG_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.FIVE_KIND))
        assertEquals(20, rules.calculateScore(dice, YahtzeeLowerCategory.CHANCE))
        scoreCard.setScore(YahtzeeLowerCategory.LONG_STRAIGHT, dice)
    }

    @Test
    fun fiveKind() {
        val dice = Dice(initVals=listOf(4, 4, 4, 4, 4))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.ONES))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.TWOS))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.THREES))
        assertEquals(20, rules.calculateScore(dice, CommonUpperCategory.FOURS))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.FIVES))
        assertEquals(0, rules.calculateScore(dice, CommonUpperCategory.SIXES))
        assertEquals(20, rules.calculateScore(dice, YahtzeeLowerCategory.THREE_KIND))
        assertEquals(20, rules.calculateScore(dice, YahtzeeLowerCategory.FOUR_KIND))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.FULL_HOUSE))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.SHORT_STRAIGHT))
        assertEquals(0, rules.calculateScore(dice, YahtzeeLowerCategory.LONG_STRAIGHT))
        assertEquals(50, rules.calculateScore(dice, YahtzeeLowerCategory.FIVE_KIND))
        assertEquals(20, rules.calculateScore(dice, YahtzeeLowerCategory.CHANCE))
        scoreCard.setScore(YahtzeeLowerCategory.FIVE_KIND, dice)
        val nextDice = Dice(initVals=listOf(3, 3, 3, 3, 3))
        assertEquals(listOf(YahtzeeBonus()), rules.getMatchingActions(dice, scoreCard))
    }

    @Test
    fun calculateScoreWithInvalidCategory() {
        val dice = Dice(initVals=listOf(1, 2, 3, 2, 3))
        assertThrows(InvalidCategoryError::class.java) {rules.calculateScore(dice, BadCategory.BAD_CATEGORY)}
    }
}