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
        return combinationLock.hitZeroCount // Part Two
    }
}

class CombinationLock {
    var pointingAt = 50
    val minInteger = 0
    val maxInteger = 99

    var stopsAtZeroCount = 0
    var hitZeroCount = 0

    fun rotateLeft() {
        pointingAt--
        if (pointingAt < minInteger) { pointingAt = maxInteger }
        if (pointingAt == 0) { hitZeroCount++ }
    }

    fun rotateRight() {
        pointingAt++
        if (pointingAt > maxInteger) { pointingAt = minInteger }
        if (pointingAt == 0) { hitZeroCount++ }
    }

    fun rotate(rotation: Int) {

        for (i in 0 .. rotation - 1) {
            rotateRight()
        }

        for (i in 0 downTo rotation + 1) {
            rotateLeft()
        }

        if (pointingAt == 0) {
            stopsAtZeroCount++
        }
    }
}
