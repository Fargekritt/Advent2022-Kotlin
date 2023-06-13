package day3

import java.io.File

fun main() {
    val text = readFile()
    println("partA: " + partA(text))
    println("partB: " + partB(text))
}


fun readFile(): String {
    return File("day3/Input").bufferedReader().use { it.readText() }
}

fun partA(text: String): Int {
    val ruckSack: List<String> = text.split("\r\n")
    var score = 0

    for (i in ruckSack.indices) {
        val compartments: List<String> =
            listOf(ruckSack[i].substring(0, ruckSack[i].length / 2), ruckSack[i].substring(ruckSack[i].length / 2))

        val found: MutableList<Char> = MutableList(1) { _ -> 'a' }
        for (ch in compartments[0]) {
            if (compartments[1].contains(ch) && !found.contains(ch)) {
                found.add(ch)
                score += if (ch.isLowerCase()) {
                    (ch - 'a') + 1
                } else {
                    (ch - 'A') + 27
                }
            }
        }
    }
    return score
}

fun partB(text: String): Int {
    var score = 0
    val ruckSack: List<List<Char>> = text.split("\r\n")
        .map { it ->
            it.split("")
                .filter { !it.contentEquals("") }
                .map { it[0] }
        }
    for (i in ruckSack.indices step 3) {
        for (ch in ruckSack[i]) {

            if (ruckSack[i + 1].contains(ch) && ruckSack[i + 2].contains(ch)) {

                score += if (ch.isLowerCase()) {
                    (ch - 'a') + 1
                } else {
                    (ch - 'A') + 27
                }
                break
            }
        }

    }


    return score
}