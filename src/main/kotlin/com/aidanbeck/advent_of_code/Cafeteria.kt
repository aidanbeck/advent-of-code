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

    fun parseIds(): Array<Int> {
        val idStrings = puzzleInput.split("\n\n")[1].split('\n') // get all lines AFTER empty line
        val ids = ArrayList<Int>()

        for (idString in idStrings) {
            ids.add( idString.toInt() )
        }

        return ids.toTypedArray()
    }

    fun isIdWithinRange(id: Int, range: Range): Boolean {

        return id <= range.max && id >= range.min
    }

    fun isIdFresh(id: Int): Boolean {

        for (range in ranges) {
            if (isIdWithinRange(id, range)) {
                return true
            }
        }

        return false

    }

    fun getFreshIds(): Array<Int> {

        val freshIds = ArrayList<Int>()

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
}
