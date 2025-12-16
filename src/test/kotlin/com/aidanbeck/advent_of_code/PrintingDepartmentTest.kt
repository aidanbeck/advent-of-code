package com.aidanbeck.advent_of_code

import kotlin.test.Test
import kotlin.test.assertContentEquals
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

    // PART TWO

    @Test
    fun testSetTile() {
        val printingDepartment = PrintingDepartment(puzzleInput)

        printingDepartment.setTile(0,0,'a')
        printingDepartment.setTile(4,2,'b')
        printingDepartment.setTile(9,9,'c')
        printingDepartment.setTile(20,20,'d')

        assertEquals('a', printingDepartment.getTile(0,0))
        assertEquals('b', printingDepartment.getTile(4,2))
        assertEquals('c', printingDepartment.getTile(9,9))
        assertEquals('_', printingDepartment.getTile(20,20))
    }

    @Test
    fun testGetMoveableCoordinates() {
        val printingDepartment = PrintingDepartment(puzzleInput)

        val moveableCoordinates = arrayOf(
            Coordinate(0,2),
            Coordinate(0,3),
            Coordinate(0,5),
            Coordinate(0,6),
            Coordinate(0,8),
            Coordinate(1,0),
            Coordinate(2,6),
            Coordinate(4,0),
            Coordinate(4,9),
            Coordinate(7,0),
            Coordinate(9,0),
            Coordinate(9,2),
            Coordinate(9,8)
        )

        assertContentEquals(moveableCoordinates, printingDepartment.getMoveableCoordinates())
    }

    @Test
    fun testMoveTiles() {
        val before =
"""XXX
XXX
XXX"""
        val after =
"""XXX
X.X
XX."""
        val printingDepartment = PrintingDepartment(before)
        printingDepartment.moveTiles(
            arrayOf(
                Coordinate(1,1),
                Coordinate(2,2),
            )
        )

        assertEquals(after, printingDepartment.tiles)
    }

    @Test
    fun testSolvePartTwo() {
        val printingDepartment = PrintingDepartment(puzzleInput)

        assertEquals(43, printingDepartment.solvePartTwo())
    }
}