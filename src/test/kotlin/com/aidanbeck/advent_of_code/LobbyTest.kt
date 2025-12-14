package com.aidanbeck.advent_of_code

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertContentEquals

class LobbyTest {
    @Test
    fun testGetJoltage() {

        val lobby = Lobby()

        assertEquals("98", lobby.getJoltage("987654321111111"))
        assertEquals("89", lobby.getJoltage("811111111111119"))
        assertEquals("78", lobby.getJoltage("234234234234278"))
        assertEquals("92", lobby.getJoltage("818181911112111"))
    }

    @Test
    fun testGetJoltages() {
        val lobby =  Lobby()

        val banks = arrayOf("987654321111111", "811111111111119", "234234234234278", "818181911112111")
        val joltages = arrayOf("98", "89", "78", "92")

        assertContentEquals(joltages, lobby.getJoltages(banks))
    }

    @Test
    fun testSolvePartOne() {
        val lobby = Lobby()
        val puzzleInput =
"""987654321111111
811111111111119
234234234234278
818181911112111"""

        assertEquals(357, lobby.solvePartOne(puzzleInput))
    }

    // PART TWO

    @Test
    fun testGetJoltage2() {

        val lobby = Lobby()

        assertEquals("987654321111", lobby.getJoltage2("987654321111111"))
        assertEquals("811111111119", lobby.getJoltage2("811111111111119"))
        assertEquals("434234234278", lobby.getJoltage2("234234234234278"))
        assertEquals("888911112111", lobby.getJoltage2("818181911112111"))
    }

    @Test
    fun testGetJoltages2() {
        val lobby =  Lobby()

        val banks = arrayOf("987654321111111", "811111111111119", "234234234234278", "818181911112111")
        val joltages = arrayOf("987654321111", "811111111119", "434234234278", "888911112111")

        assertContentEquals(joltages, lobby.getJoltages2(banks))
    }

    @Test
    fun testSolvePartTwo() {
        val lobby = Lobby()
        val puzzleInput =
"""987654321111111
811111111111119
234234234234278
818181911112111"""

        assertEquals(3121910778619, lobby.solvePartTwo(puzzleInput))
    }
}