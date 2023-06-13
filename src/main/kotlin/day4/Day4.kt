package day4

import java.io.File

fun main() {
    val text = readFile()
    partA(text)

}

fun readFile(): String {
    return File("day4/Test").bufferedReader().use { it.readText() }
}

fun partA(text: String) {
    val lines: List<String> = text.split("/r/n")
    println(lines)
}