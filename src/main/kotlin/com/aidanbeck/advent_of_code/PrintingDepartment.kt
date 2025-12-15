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
    fun getTile(x: Int, y: Int) = '.'
    fun getAdjacentTiles(x: Int, y: Int) = "........"
    fun isTileMoveable(x: Int, y: Int) = false
    fun countMoveableTiles() = 0
}