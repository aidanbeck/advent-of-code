package com.aidanbeck.advent_of_code

class PrintingDepartment(val tiles: String) {
    var width = calculateWidth()
    var height = calculateHeight()

    fun calculateWidth(): Int {
        return tiles.indexOf('\n')
    }
    fun calculateHeight(): Int {
        return tiles.length / tiles.indexOf('\n')
    }
    fun getTile(x: Int, y: Int): Char {

        if (x < 0 || x >= width || y < 0 || y >= height) {
            return '_' // off-grid
        }

        // y is added to account for spacing from the \n characters, which I'm not considering as part of the grid.
        return tiles[ width*y+x +y]
    }
    fun getAdjacentTiles(x: Int, y: Int): String {

        // get tiles in a clockwise direction, starting at 12
        // 701
        // 6 2
        // 543
        // also, -y is "up"

        val adjacentTiles = charArrayOf(
            getTile(x    , y - 1),
            getTile(x + 1, y - 1),
            getTile(x + 1, y    ),
            getTile(x + 1, y + 1),
            getTile(x    , y + 1),
            getTile(x - 1, y + 1),
            getTile(x - 1, y    ),
            getTile(x - 1, y - 1)
        )

        return String(adjacentTiles)
    }

    fun isTileMoveable(x: Int, y: Int): Boolean {

        val adjacentTiles = getAdjacentTiles(x, y)
        var sumAdjacentObstructions = 0

        for (char in adjacentTiles) {
            if (char == '@') {
                sumAdjacentObstructions++
            }
        }

        if (sumAdjacentObstructions < 4) {
            return true
        }

        return false

    }

    fun countMoveableTiles(): Int {

        var sumMoveableTiles = 0

        for (y in 0..height) {
            for (x in 0..width) {
                if (getTile(x, y) == '@' && isTileMoveable(x, y)) {
                    sumMoveableTiles++
                }
            }
        }

        return sumMoveableTiles
    }
}