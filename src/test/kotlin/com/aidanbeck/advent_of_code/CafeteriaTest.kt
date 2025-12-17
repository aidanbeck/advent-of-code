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
        
        val ids = arrayOf(1, 5, 8, 11, 17, 32)
        assertContentEquals(ids, cafeteria.parseIds())
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
    fun testGetFreshIds() {
        val cafeteria = Cafeteria(puzzleInput)
        val freshIds = arrayOf(5, 11, 17)

        assertContentEquals(freshIds, cafeteria.getFreshIds())
    }

    @Test
    fun testCountFreshIds() {
        val cafeteria = Cafeteria(puzzleInput)
        assertEquals(3, cafeteria.countFreshIds())
    }
}