package com.aidanbeck.advent_of_code

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class GiftShopTest {

    @Test
    fun testRangeGetIds() {

        val range = Range(22220, 22225)
        val ids = arrayOf(22220, 222221, 22223, 22224, 22225)
        assertEquals(ids, range.getIds())
    }

    @Test
    fun testParseRanges() {

        val parsedRanges = GiftShop().parseRanges("11-22,95-115,998-1012,1188511880-1188511890,222220-222224")
        val rangeArray = arrayOf(
            Range(11, 22),
            Range(95, 115),
            Range(998, 1012),
            Range(1188511880, 1188511890),
            Range(222220, 222224)
        )

        assertContentEquals(rangeArray, parsedRanges)
    }

    @Test
    fun testGetAllIds() {

        val ranges = arrayOf(
            Range(11, 22),
            Range(95, 115),
            Range(998, 1012)
        )

        val ids = arrayOf(
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
            95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115,
            998, 999, 1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010, 1011, 1012
        )

        assertContentEquals(ids, GiftShop().getAllIds(ranges) )
    }

    @Test
    fun testIdIsValid() {
        val giftShop = GiftShop()
        assertTrue( giftShop.idIsValid(123123) )
        assertFalse( giftShop.idIsValid(137) )
    }

    @Test
    fun testSumInvalidIds() {
        val ids = arrayOf(
            11, 22, 99, 1010, 1188511885, 222222, 446446, 38593859, // invalid ids, counted
            10, 23, 98, 1012, 1188511886, 223222, 444446, 38593853  // valid ids, not counted
        )
        assertEquals(1227775554, GiftShop().sumInvalidIds(ids) )
    }

    @Test
    fun testSolvePartOne() {

        val puzzleInput = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"

        assertEquals(1227775554, GiftShop().solvePartOne(puzzleInput) )

    }
}