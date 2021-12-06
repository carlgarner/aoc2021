package days.dayOne

import readFileLinesToInt

private val readings = readFileLinesToInt("inputs/d01-p01.txt")

private fun List<Int>.countIncreasing() = this.zipWithNext().count { it.first < it.second }
private fun List<Int>.windowsOfThree() = this.windowed(3, 1).map { it.sum() }

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

fun partTwo(): Int {
    var hm = HashMap<Int, Int>()
    var iter = 0
    var start = 0
    var lineSum = 0
    var total = readings.count()

    var kick = start + 3

    while(start <= total) {
        var except = false
        var end = start + 2

        for(i in start..end) {
            try {
                println("Reading line ${i.toString()}: ${readings[i].toString()}")
                lineSum += readings[i]
            } catch (e: Exception) {
                //println("Line ${i.toString()} doesn't exist, stopping inner loop")
                except = true
                break
            }
        }

        if(!except) {
            println("LineSum: ${lineSum.toString()}")
            hm.put(iter, lineSum)
            ++iter
            ++start
            lineSum = 0

            if(start > kick) {
                start = kick + 1
                kick = start + 3

                println("Setting start to: ${start.toString()}")
                println("Setting kick to: ${kick.toString()}")
            }
        } else {
            except = false
            hm.put(iter, lineSum)
            //println("Exiting loop - lineSum: ${lineSum.toString()} - start: ${start.toString()} - end: ${end.toString()}")
            break
        }
    }

    println("HashMap: ${hm.values.toString()}\n")

    var items = -1;
    var last = 0;

    for(item in hm.values) {
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

fun partTwoV2() = readings.windowsOfThree().countIncreasing()