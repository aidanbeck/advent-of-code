package com.aidanbeck.advent_of_code

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

internal class SecretEntranceTest {

    @Test
    fun testAddOne() {
        val secretEntrance = SecretEntrance()
        val result = secretEntrance.addOne(0)
        assertEquals(1, result)
    }

    @Test
    fun testParseRotationSequence() {

        val puzzleInput =
"""L68
L30
R48
L5
R60
L55
L1
L99
R14
L82""" // I hate this formatting! STUDY how can I format multi-line strings in code differently?

        val desiredOutput = arrayOf(-68, -30, 48, -5, 60, -55, -1, -99, 14, -82)
        val parsedOutput = SecretEntrance().parseRotationSequence(puzzleInput)

        assertContentEquals(parsedOutput, desiredOutput)
    }

//    @Test
//    fun testCombinationLock() {
//        val combinationLock = CombinationLock()
//    }
}

/*
    Kotlin Testing Notes
    https://www.jetbrains.com/help/idea/tdd-with-kotlin.html

    Create A Test:
    - Place cursor inside test class.
    - Press Alt + Insert.

    Deal With Not-Yet Created Classes
    - Call the class anyway.
    - On it, Press Alt + Enter.
    - Click "Create Class".
    - Extract to separate file.
    - Select main>kotlin>[package].
    - The empty class will then be created for real in the desired package.
    - Then, hit Alt + Enter again to import it.

    Deal With Not-Yet Created Methods
    - On it, Press Alt + Enter.
    - Click "Create Member Function".
    - This then creates an empty function in the correct class.
    - Modify the function just to ensure it returns the correct type.

    Running Tests
    - Re-Run the last Test Class: Shift + F10
    - Put the Cursor inside a specific Test Method and press Ctrl + Shift + F10 to just run that test
    - Do the same in the class itself to run that class.
 */