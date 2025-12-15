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

        // y is added to account for spacing from the \n characters, which I'm not considering as part of the grid.
        return tiles[ width*y+x +y]
    }
    fun getAdjacentTiles(x: Int, y: Int) = "........"
    fun isTileMoveable(x: Int, y: Int) = false
    fun countMoveableTiles() = 0
}