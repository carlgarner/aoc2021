package days.dayThree

import readFileLinesToString

private val readings = readFileLinesToString("inputs/d03-p01.txt")
private val counts = hashMapOf(0 to 0, 1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0, 6 to 0, 7 to 0, 8 to 0, 9 to 0, 10 to 0, 11 to 0)

fun partOne(): Int {
    var total = readings.count()
    var gamma = ""
    var epsilon = ""

    for(line in readings) {
        for(ch in line.indices) {
            counts.replace(ch, counts.getValue(ch) + line[ch].digitToInt())
        }
    }

    println("Counts: $counts")

    for((key, value) in counts) {
        var test = total - value

        gamma += if (test > value) '0' else '1'
    }

    for(part in gamma.toCharArray()) {
        when(part) {
            '0' -> epsilon += '1'
            '1' -> epsilon += '0'
        }
    }

    //println("Gamma: ${gamma} (dec: ${gamma.toInt(2)})")
    //println("Epsilon: ${epsilon} (dec: ${epsilon.toInt(2)})")

    return gamma.toInt(2) * epsilon.toInt(2)
}

fun partTwo(): Int {
    var oxygen = ""
    var co2 = ""
    var oxyList: MutableList<String> = ArrayList<String>()
    var co2List: MutableList<String> = ArrayList<String>()
    var (zeros, ones) = readings.partition { it.startsWith('0') }

    if(zeros.count() > ones.count()) {
        oxyList.addAll(ones)
        co2List.addAll(zeros)
    } else {
        oxyList.addAll(zeros)
        co2List.addAll(ones)
    }

    println("Zero count: ${zeros.count()}")
    println("Ones count: ${ones.count()}")



    return 0
}