package com.aidanbeck.advent_of_code

class Range (val max: Int, val min: Int) {
    fun getIds(): Array<Int> { return arrayOf(0) }
}

class GiftShop {
    fun parseRanges(rangeString: String): Array<Range> { return arrayOf( Range(0,0) ) }
    fun getAllIds(ids: Array<Range>): Array<Int> { return arrayOf(0) }
    fun idIsValid(id: Int): Boolean { return false }
    fun sumInvalidIds(ids: Array<Int>): Int { return 0 }

    fun solvePartOne(puzzleInput: String): Int { return 0 }
}