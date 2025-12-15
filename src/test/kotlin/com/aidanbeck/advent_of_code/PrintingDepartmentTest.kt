package com.aidanbeck.advent_of_code

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class PrintingDepartmentTest {

    // global puzzle solution
    val puzzleInput =
"""..@@.@@@@.
@@@.@.@.@@
@@@@@.@.@@
@.@@@@..@.
@@.@@@@.@@
.@@@@@@@.@
.@.@.@.@@@
@.@@@.@@@@
.@@@@@@@@.
@.@.@@@.@."""

    @Test
    fun testCalculateWidth() {
        val printingDepartment = PrintingDepartment(puzzleInput)
        assertEquals(10, printingDepartment.calculateWidth())
    }

    @Test
    fun testCalculateHeight() {
        val printingDepartment = PrintingDepartment(puzzleInput)
        assertEquals(10, printingDepartment.calculateHeight())
    }

    @Test
    fun testGetTile() {
        val printingDepartment = PrintingDepartment(puzzleInput)
        assertEquals('.', printingDepartment.getTile(0,0))
        assertEquals('@', printingDepartment.getTile(4,4))
        assertEquals('@', printingDepartment.getTile(8,9))
        assertEquals('.', printingDepartment.getTile(6,3))
        assertEquals('.', printingDepartment.getTile(7,9))
        assertEquals('_', printingDepartment.getTile(10,9))
    }

    @Test
    fun testGetAdjacentTiles() {
        // character order should be clockwise, starting at 12:00
        // return @, ., or _
        val printingDepartment = PrintingDepartment(puzzleInput)
        assertEquals("__.@@___", printingDepartment.getAdjacentTiles(0,0))
        assertEquals("@@@.@@@@", printingDepartment.getAdjacentTiles(4,6))
        assertEquals("._____@@", printingDepartment.getAdjacentTiles(9,9))
    }

    @Test
    fun testIsTileMoveable() {
        val printingDepartment = PrintingDepartment(puzzleInput)
        assertTrue(printingDepartment.isTileMoveable(2, 0))
        assertTrue(printingDepartment.isTileMoveable(6, 2))
        assertFalse(printingDepartment.isTileMoveable(4, 7))
        assertFalse(printingDepartment.isTileMoveable(8, 2))
    }

    @Test
    fun testCountMoveableTiles() {
        val printingDepartment = PrintingDepartment(puzzleInput)
        assertEquals(13, printingDepartment.countMoveableTiles())
    }
}