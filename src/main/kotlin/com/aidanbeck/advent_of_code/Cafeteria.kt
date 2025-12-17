package com.aidanbeck.advent_of_code

// class Range(min: Int, max: Int) // already defined in GiftShop- can I just reuse from there?

class Cafeteria(val puzzleInput: String) {

    val ranges = parseRanges()
    val ids = parseIds()

    fun parseRanges(): Array<Range> {
        val rangeStrings = puzzleInput.split("\n\n")[0].split('\n') // get all lines BEFORE empty line
        val ranges = ArrayList<Range>()

        for (rangeString in rangeStrings) {
            val minMaxStrings: List<String> = rangeString.split('-')
            val min = minMaxStrings[0].toLong()
            val max = minMaxStrings[1].toLong()

            ranges.add( Range(min, max) )
        }

        return ranges.toTypedArray()
    }

    fun parseIds(): Array<Long> {
        val idStrings = puzzleInput.split("\n\n")[1].split('\n') // get all lines AFTER empty line
        val ids = ArrayList<Long>()

        for (idString in idStrings) {
            ids.add( idString.toLong() )
        }

        return ids.toTypedArray()
    }

    fun isIdWithinRange(id: Long, range: Range): Boolean {

        return id <= range.max && id >= range.min
    }

    fun isIdFresh(id: Long): Boolean {

        for (range in ranges) {
            if (isIdWithinRange(id, range)) {
                return true
            }
        }

        return false

    }

    fun getFreshIds(): Array<Long> {

        val freshIds = ArrayList<Long>()

        for (id in ids) {
            if (isIdFresh(id)) {
                freshIds.add(id)
            }
        }

        return freshIds.toTypedArray()
    }

    fun countFreshIds(): Int {
        return getFreshIds().size
    }

    fun getAllPossibleIds(): LongArray = longArrayOf(1L)

    fun countAllPossibleIds(): Int = 0


}
