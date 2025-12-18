package com.aidanbeck.advent_of_code

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class CafeteriaTest {
    val puzzleInput =
"""3-5
10-14
16-20
12-18

1
5
8
11
17
32"""

    @Test
    fun testParseRanges() {
        val cafeteria = Cafeteria(puzzleInput)
        val ranges = arrayOf(
            Range(3,5),
            Range(10,14),
            Range(16,20),
            Range(12,18)
        )
        assertContentEquals(ranges, cafeteria.parseRanges())
    }

    @Test
    fun testParseIds() {
        val cafeteria = Cafeteria(puzzleInput)

        val ids = longArrayOf(1, 5, 8, 11, 17, 32)
        assertContentEquals(ids, cafeteria.parseIds().toLongArray())
    }

    @Test
    fun testIsIdWithinRange() {
        val cafeteria = Cafeteria(puzzleInput)
        assertTrue(cafeteria.isIdWithinRange(10, Range(5, 15) ) )
        assertTrue(cafeteria.isIdWithinRange(5, Range(5, 15) ) )
        assertTrue(cafeteria.isIdWithinRange(15, Range(5, 15) ) )

        assertFalse(cafeteria.isIdWithinRange(16, Range(5, 15) ) )
    }

    @Test
    fun testIsIdFresh() {
        val cafeteria = Cafeteria(puzzleInput)

        assertTrue(cafeteria.isIdFresh(5))
        assertTrue(cafeteria.isIdFresh(11))
        assertTrue(cafeteria.isIdFresh(17))

        assertFalse(cafeteria.isIdFresh(1))
        assertFalse(cafeteria.isIdFresh(8))
        assertFalse(cafeteria.isIdFresh(32))
    }

    @Test
    fun testGetFreshIds() {
        val cafeteria = Cafeteria(puzzleInput)
        val freshIds = longArrayOf(5, 11, 17)

        assertContentEquals(freshIds, cafeteria.getFreshIds().toLongArray()) // STUDY why do I need .toLongArray() here when it is already outputting an Array<Long>? There is something I still need to understand.
    }

    @Test
    fun testCountFreshIds() {
        val cafeteria = Cafeteria(puzzleInput)
        assertEquals(3, cafeteria.countFreshIds())
    }

    @Test
    fun testCountAllPossibleIds() {

        val cafeteria = Cafeteria(puzzleInput)
//        val ranges = arrayOf(
//            Range(1, 10), // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10  +10 ids
//            Range(2, 6),  //                                +0  ids
//            Range(5, 15), // 11, 12, 13, 14, 15             +5  ids
//            Range(20, 25) // 20, 21, 22, 23, 24, 25         +6  ids
//        )                 //                                =21 total ids


        assertEquals(14, cafeteria.countAllPossibleIds())
    }
}