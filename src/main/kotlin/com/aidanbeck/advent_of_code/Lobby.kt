package com.aidanbeck.advent_of_code

class Lobby {
    fun getJoltage(batteries: String): String {

        var significantDigit = 0
        var significantIndex = 0

        // Find most significant digit, excluding final digit
        for (i in 0..batteries.length - 2) {

            val digit = batteries[i].toString().toInt()
            if (digit > significantDigit) {
                significantDigit = digit
                significantIndex = i
            }
        }

        // Find second most significant digit, including final digit
        // STUDY this works but kind of breaks DRY. A good one to compare with other's solutions!
        var secondSignificantDigit = 0
        for (i in significantIndex + 1 .. batteries.length - 1) {

            val digit = batteries[i].toString().toInt()
            if (digit > secondSignificantDigit) {
                secondSignificantDigit = digit
            }
        }

        return "$significantDigit$secondSignificantDigit"
    }

    fun getJoltages(banks: Array<String>): Array<String> {

        var joltages = ArrayList<String>()

        for (bank in banks) {
            joltages.add( getJoltage(bank) )
        }

        return joltages.toTypedArray()
    }

    fun solvePartOne(puzzleInput: String): Int {

        val banks = puzzleInput.split('\n').toTypedArray() //STUDY brush up on differences between List and Array
        val joltages = getJoltages(banks)

        var sum = 0
        for (joltage in joltages) {
            sum += joltage.toInt()
        }

        return sum
    }

    // PART TWO

    fun getJoltage2(batteries: String): String {

        var joltage = ""
        var lastUsedIndex = -1 // -1 allows for index 0 to be used.

        for (i in 0..11) { // For all 12 digits

            val digitsRemaining = 11 - i
            val lastSafeIndex = batteries.length - 1 - digitsRemaining
            var largestDigitFound = 0

            // for all digits except the remaining
            for (j in lastUsedIndex + 1..lastSafeIndex) {

                val digit = batteries[j].toString().toInt()
                if (digit > largestDigitFound) {
                    largestDigitFound = digit
                    lastUsedIndex = j
                }
            }

            joltage += "$largestDigitFound"

        }

        return joltage
    }

    fun getJoltages2(banks: Array<String>): Array<String> {

        var joltages = ArrayList<String>()

        for (bank in banks) {
            joltages.add( getJoltage2(bank) ) // !!! MAJOR DRY violation! Just changes a single character. I should rethink the best way to include Part 1 and Part 2 functionality within the same class.
        }

        return joltages.toTypedArray()

    }

    fun solvePartTwo(puzzleInput: String): Long {

        val banks = puzzleInput.split('\n').toTypedArray()
        val joltages = getJoltages2(banks)

        var sum: Long = 0 // another DRY violation, only difference is function called and Long vs Int. Rethink organization for next puzzle.
        for (joltage in joltages) {
            sum += joltage.toLong()
        }

        return sum

    }
}
