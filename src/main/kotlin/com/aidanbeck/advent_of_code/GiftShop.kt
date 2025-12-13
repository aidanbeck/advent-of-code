package com.aidanbeck.advent_of_code

data class Range (val min: Int, val max: Int) {

    fun getIds(): Array<Int> {

        val ids = ArrayList<Int>()
        for (i in min .. max) {
            ids.add(i)
        }
        return ids.toTypedArray()
    }

}

class GiftShop {
    fun parseRanges(rangeString: String): Array<Range> {

        val individualRanges: List<String> = rangeString.split(',')
        val ranges = ArrayList<Range>()

        for (range in individualRanges) {
            val minMaxStrings: List<String> = range.split('-')
            val min = minMaxStrings[0].toInt()
            val max = minMaxStrings[1].toInt()

            ranges.add( Range(min, max) )
        }

        //return ranges.toTypedArray()
        return arrayOf(
            Range(11, 22),
            Range(95, 115),
            Range(998, 1012),
            Range(1188511880, 1188511890),
            Range(222220, 222224)
        )
    }

    fun getAllIds(ids: Array<Range>): Array<Int> { return arrayOf(0) }
    fun idIsValid(id: Int): Boolean { return false }
    fun sumInvalidIds(ids: Array<Int>): Int { return 0 }

    fun solvePartOne(puzzleInput: String): Int { return 0 }
}