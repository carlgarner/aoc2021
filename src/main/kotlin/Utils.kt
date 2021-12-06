import java.io.File

fun readFileLinesToString(fileName: String): List<String> = File(fileName).readLines()
fun readFileLinesToInt(fileName: String): List<Int> = File(fileName).readLines().map { it.toInt() }