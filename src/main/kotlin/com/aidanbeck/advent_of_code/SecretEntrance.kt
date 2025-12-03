package com.aidanbeck.advent_of_code

class SecretEntrance {

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

    fun solvePuzzle(puzzleString: String): Int {

        val rotations: Array<Int> = parseRotationSequence(puzzleString)

        val combinationLock = CombinationLock()

        for (rotation in rotations) {
            combinationLock.rotate(rotation)
        }

        //return combinationLock.stopsAtZeroCount // Part One
        return combinationLock.crossedZeroCount // Part Two
    }
}

class CombinationLock {
    var pointingAt = 50
    var stopsAtZeroCount = 0
    var crossedZeroCount = 0
    val minInteger = 0
    val maxInteger = 99

    var startedFromZero = false

    fun rotate(rotation: Int) {

        if (pointingAt == 0) { // if a rotation started on zero, don't increment crossedCount until it's already crossed around again.
            startedFromZero = true
        } else {
            startedFromZero = false
        }

        pointingAt += rotation


        while (pointingAt > maxInteger) {
            pointingAt -= maxInteger + 1

            if (pointingAt != 0 && !startedFromZero) { // avoid double counting when it crosses over AND lands on zero
                crossedZeroCount++
            }

            startedFromZero = false // now that it has passed off zero, let it have the possibility to count on the next loop
        }

        while (pointingAt < minInteger) {
            pointingAt += maxInteger + 1

            if (pointingAt != 0 && !startedFromZero) {
                crossedZeroCount++
            }

            startedFromZero = false
        }

        if (pointingAt == 0) {
            stopsAtZeroCount++
            crossedZeroCount++
        }
    }
}
