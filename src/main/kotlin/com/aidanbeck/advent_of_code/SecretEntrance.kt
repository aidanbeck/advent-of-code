package com.aidanbeck.advent_of_code

class SecretEntrance {

    fun addOne(a: Int): Int {
        return a + 1
    }

    fun parseRotationSequence(input: String): Array<Int> {

        var direction = 0
        var distanceCharacters = ""
        val rotationSequence = ArrayList<Int>()

        val puzzleString = input + '\n' // The data doesn't have a final newLine, so it's added. A bit hacky.

        for (i in 0 .. puzzleString.length - 1) {

            val character = puzzleString[i]

            when (character) {
                '\n' -> {
                    val distance = distanceCharacters.toInt()
                    distanceCharacters = "" // reset string for next rotation
                    rotationSequence.add(distance * direction)
                }
                'R' -> direction = 1
                'L' -> direction = -1
                else -> distanceCharacters += character // unsafe! assumes any other character is a number!
            }
        }

        return rotationSequence.toTypedArray()
    }
}

class CombinationLock {
    var pointingAt = 50
    var atZeroCount = 0
    val minInteger = 0
    val maxInteger = 99

    fun rotate(rotation: Int) {}
}
