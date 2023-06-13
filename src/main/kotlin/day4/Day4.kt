package day4

import java.io.File

fun main() {
    val text = readFile()
    println(partA(text))
    println(partB(text))

}

fun readFile(): String {
    return File("day4/Input").bufferedReader().use { it.readText() }
}

fun partA(text: String): Int {
    val pairs: List<List<List<Int>>> = lists(text)
    var amount = 0

    for (pair in pairs) {
        if (fullyContains(pair)) {
            amount++
        }
    }
    return amount
}

fun partB(text: String): Int{
    val pairs: List<List<List<Int>>> = lists(text)
    var amount = 0

    for (pair in pairs) {
        if (overlaps(pair)){
            amount++
        }
    }
    return amount
}

private fun lists(text: String): List<List<List<Int>>> {
    val pairs: List<List<List<Int>>> = text.split("\r\n")
            .map { it.split(",") }
            .map { pair ->
                pair.map { it.split("-") }
                        .map { strings -> strings.map { it.toInt() } }
            }
    return pairs
}

fun fullyContains(pair: List<List<Int>>): Boolean{
    return (pair[0][0] <= pair[1][0] && pair[0][1] >= pair[1][1]) || (pair[1][0] <= pair[0][0] && pair[1][1] >= pair[0][1])
}

fun overlaps(pair: List<List<Int>>): Boolean{
    return !(pair[0][0] > pair[1][1] || pair[1][0] > pair[0][1])
}