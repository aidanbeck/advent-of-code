package com.aidanbeck.advent_of_code

data class Range (val min: Long, val max: Long) {

    fun getIds(): Array<Long> {

        val ids = ArrayList<Long>()
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
            val min = minMaxStrings[0].toLong()
            val max = minMaxStrings[1].toLong()

            ranges.add( Range(min, max) )
        }

        return ranges.toTypedArray()
    }

    fun getAllIds(ranges: Array<Range>): Array<Long> {

        val ids = ArrayList<Long>()
        for (range in ranges) {

            val rangeIds = range.getIds()
            for (id in rangeIds) {
                ids.add(id)
            }
        }
        return ids.toTypedArray()
    }

    fun idIsInvalid(id: Long, part: Int): Boolean {

        if (part == 1) {
            val idChars: String = id.toString()
            val endIndex = idChars.length
            val midIndex = endIndex / 2
            val firstHalf = idChars.substring(0, midIndex)
            val secondHalf = idChars.substring(midIndex, endIndex)

            return firstHalf == secondHalf

            // STUDY there are likely smarter methods I could use to simplify this a lot!
        }

        return false

    }

    fun sumInvalidIds(ids: Array<Long>, part: Int): Long {

        var sum: Long = 0

        for (id in ids) {
            if ( idIsInvalid(id, part) ) {
                sum += id
            }
        }

        return sum
    }

    fun solvePartOne(puzzleInput: String): Long {

        val ranges = parseRanges(puzzleInput)
        val ids = getAllIds(ranges)
        return sumInvalidIds(ids, 1)
    }
}