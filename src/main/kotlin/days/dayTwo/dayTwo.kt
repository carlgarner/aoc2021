package days.dayTwo

import readFileLinesToString

private val readings = readFileLinesToString("inputs/d02-p01.txt")

fun partOne(): Int {
    var horizontal = 0
    var depth = 0

    for(item in readings) {
        var output = item.split(" ")
        var actionValue = output[1].toInt()

        when(output[0]) {
            "forward"   -> horizontal += actionValue
            "down"      -> depth += actionValue
            "up"        -> depth -= actionValue
            else        -> println("problem: ${output[0]} - ${output[1]}")
        }
    }

    return horizontal * depth
}

fun partTwo(): Int {
    var horizontal = 0
    var depth = 0
    var aim = 0

    for(item in readings) {
        var output = item.split(" ")
        var actionValue = output[1].toInt()

        when(output[0]) {
            "forward"   -> {
                horizontal += actionValue
                depth += (actionValue * aim)
            }
            "down"      -> aim += actionValue
            "up"        -> aim -= actionValue
            else        -> println("problem: ${output[0]} - ${output[1]}")
        }
    }

    return horizontal * depth
}