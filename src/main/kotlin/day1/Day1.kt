package day1

import java.io.File

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    println(biggestStream())
    println(biggestThreeStream())
}


fun biggestStream(): Int {

    //Read file into a String,
    val text: String = File("day1/Input")
        .bufferedReader().use { it.readText() }

    return text.split("\r\n\r\n")
        .map { it.lines() }
        .maxOf {
            it.sumOf { line -> line.toInt() }
        }
}

fun biggestThreeStream(): Int {

    val text: String = File("day1/Input").bufferedReader().use { it.readText() }

    return text.split("\r\n\r\n")
        .map {
            it.lines()
                .sumOf { line -> line.toInt() }
        }.sortedDescending()
        .take(3)
        .sum()

}
