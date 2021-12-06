package days.dayOne

import readFileLinesToInt

private val readings = readFileLinesToInt("inputs/d01-p01.txt")

private fun List<Int>.countIncreasing() = this.zipWithNext().count { it.first < it.second }

fun partOne(): Int {
    var items = -1;
    var last = 0;

    for(item in readings) {
        if(items > -1) {
            if(item > last) {
                ++items
            }
            last = item
        } else {
            last = item
            items = 0
        }
    }

    return items
}

fun partOneV2() = readings.countIncreasing()