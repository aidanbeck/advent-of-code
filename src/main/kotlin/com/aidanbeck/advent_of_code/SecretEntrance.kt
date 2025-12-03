package com.aidanbeck.advent_of_code

class SecretEntrance {

    fun addOne(a: Int): Int {
        return a + 1
    }

    fun parseRotationSequence(input: String): Array<Rotation> {

        var directionCharacter = '_'
        var distanceCharacters = ""
        val rotationSequence = ArrayList<Rotation>()

        val puzzleString = input + '\n' // The data doesn't have a final newLine, so it's added. A bit hacky.

        for (i in 0 .. puzzleString.length - 1) {

            val character = puzzleString[i]

            when (character) {
                '\n' -> {
                    val distance = distanceCharacters.toInt()

                    rotationSequence.add(
                        Rotation(directionCharacter, distance)
                    )

                    distanceCharacters = "" // reset string for next rotation
                }
                'R', 'L' -> {
                    directionCharacter = character
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

data class Rotation(
    val direction: Char, // 'L' or 'R'
    val distance: Int
)