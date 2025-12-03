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
                'L' -> {
                    direction = -1
                }
                else -> {
                    // This is not safe and will assume any other character is a number.
                    // I am okay with this flaw because it will not see production.
                    distanceCharacters += character
                }
            }
        }

        return rotationSequence.toTypedArray()
    }
}

//class CombinationLock {
//    var pointingAt = 50
//    val minInteger = 0
//    val maxInteger = 99
//
//    fun rotate()
//}

data class Rotation(
    val direction: Char, // 'L' or 'R'
    val distance: Int
)

