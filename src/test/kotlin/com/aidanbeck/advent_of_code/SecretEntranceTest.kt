package com.aidanbeck.advent_of_code

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import kotlin.test.assertEquals

internal class SecretEntranceTest {

    @Test
    @DisplayName("Addition 1+2=3")
    fun testSomeMath() {
        Assertions.assertEquals(1 + 2, 3)
    }

    @Test
    fun testAddOne() {
        val secretEntrance = SecretEntrance()
        val result = secretEntrance.addOne(0)
        assertEquals(1, result)
    }
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

 */