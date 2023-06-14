package day5

import java.io.File

fun main(){
    val text = readFile()
    val (stack, moves) = text.split("\r\n\r\n")
    val test =  stack.split("\r\n").map { it.split(" ") }
    println(test.size)
    for (strings in test) {
        println(strings.size)
    }
    println("=====")
    println(moves)
}

fun readFile(): String{
    return File("day5/test").bufferedReader().use { it.readText() }
}