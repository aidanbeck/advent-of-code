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
}