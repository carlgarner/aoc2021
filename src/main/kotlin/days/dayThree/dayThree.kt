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
    var mostCommon = '0'
    var leastCommon = '0'
    var readingsClone = readings.toMutableList()

    run oxygen@ {
        readings.first().toCharArray().forEachIndexed { i, c ->
            var count = 0
            readingsClone.forEach { count += if(it.toCharArray()[i] == '1') 1 else -1 }
            mostCommon = if(count >= 0) '1' else '0'

            //println("Most Common (${i}): ${mostCommon}")

            readingsClone.toMutableList().forEach {
                if(it[i] != mostCommon)
                    readingsClone.remove(it)

                if(readingsClone.size == 1) {
                    //println("FINAL: ${readingsClone}")
                    return@oxygen
                }
            }

            //println("Lenght: ${readingsClone.size}")
        }
    }

    oxygen = readingsClone.first()
    readingsClone = readings.toMutableList()

    run scrubber@ {
        readings.first().toCharArray().forEachIndexed { i, c ->
            var count = 0
            readingsClone.forEach { count += if(it.toCharArray()[i] == '1') 1 else -1 }
            leastCommon = if(count >= 0) '0' else '1'

            //println("Least Common (${i}): ${leastCommon}")

            readingsClone.toMutableList().forEach {
                if(it[i] != leastCommon)
                    readingsClone.remove(it)

                if(readingsClone.size == 1) {
                    //println("FINAL: ${readingsClone}")
                    return@scrubber
                }
            }

            //println("Lenght: ${readingsClone.size}")
        }
    }

    co2 = readingsClone.first()

    //println("Oxygen: ${oxygen} - (dec: ${oxygen.toInt(2)})")
    //println("CO2: ${co2} - (dec: ${co2.toInt(2)})")

    return oxygen.toInt(2) * co2.toInt(2)
}