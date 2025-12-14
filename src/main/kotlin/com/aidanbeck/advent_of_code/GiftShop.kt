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

        val idChars: String = id.toString()
        val halfLength = idChars.length / 2

        if (part == 1) {
            val firstHalf = idChars.substring(0, halfLength)
            val secondHalf = idChars.substring(halfLength, idChars.length)
            return firstHalf == secondHalf

        } else if (part != 2) {
            throw Error("Part can only be 1 or 2!")
        }

        // SOLVE PART 2

        // Get all possible segment lengths
        val possibleSegmentLengths = arrayListOf<Int>()
        for (i in 1..halfLength) {
            if (idChars.length % i == 0) { // length is divisible by i
                possibleSegmentLengths.add(i)
            }
        }

        // Split ID into segments for each possible segment
        // Results in groups of segments, one group for each possible segment length
        val segmentGroups = ArrayList<ArrayList<String>>()
        for (segmentLength in possibleSegmentLengths) {

            val segments = arrayListOf<String>()
            for (i in 0..idChars.length - segmentLength step segmentLength) {
                segments.add( idChars.substring(i, i + segmentLength) )
            }
            segmentGroups.add(segments)
        }

        // Compare segments within each group
        for (segmentGroup in segmentGroups) {

            var previousSegment = segmentGroup[0]
            var allSegmentsMatch = true

            for (segment in segmentGroup) {
                if (segment != previousSegment) {
                    allSegmentsMatch = false
                }
                previousSegment = segment
            }

            if (allSegmentsMatch) { // at least one group had all matching segments
                return true
            }
        }

        // no segment groups match
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

    fun solvePartTwo(puzzleInput: String): Long {

        val ranges = parseRanges(puzzleInput)
        val ids = getAllIds(ranges)
        return sumInvalidIds(ids, 2)
    }
}