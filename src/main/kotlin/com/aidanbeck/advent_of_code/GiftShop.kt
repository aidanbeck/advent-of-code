package com.aidanbeck.advent_of_code

class Range (val min: Int, val max: Int) {

    fun getIds(): Array<Int> {

        val ids = ArrayList<Int>()
        for (i in min .. max) {
            ids.add(i)
        }
        return ids.toTypedArray()
    }

}

class GiftShop {
    fun parseRanges(rangeString: String): Array<Range> { return arrayOf( Range(0,0) ) }
    fun getAllIds(ids: Array<Range>): Array<Int> { return arrayOf(0) }
    fun idIsValid(id: Int): Boolean { return false }
    fun sumInvalidIds(ids: Array<Int>): Int { return 0 }

    fun solvePartOne(puzzleInput: String): Int { return 0 }
}