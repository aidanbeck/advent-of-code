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

    fun getJoltage2(batteries: String): String = "0"
    fun getJoltages2(banks: Array<String>): Array<String> = arrayOf("0")
    fun solvePartTwo(puzzleInput: String): Long {
        return 0
    }
}
