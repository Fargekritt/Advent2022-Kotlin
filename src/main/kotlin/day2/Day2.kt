package day2

import java.io.File

/*
A, X = Rock 0
B, Y = Paper 1
C, Z = scissor 2

1 + 2 % 3
 */
fun main() {
//    println("Rock")
//    println(round('A', 'X'))
//    println(round('A', 'Y'))
//    println(round('A', 'Z'))
//
//    println("Paper")
//    println(round('B', 'Y'))
//    println(round('B', 'Z'))
//    println(round('B', 'X'))
//
//    println("Scissor")
//    println(round('C', 'Z'))
//    println(round('C', 'X'))
//    println(round('C', 'Y'))


    println(partB(readFile()))
}

fun round(opponent: Char, player: Char): Int {
    val opponentInt = opponent - 'A' + 1
    val playerInt = player - 'A' + 1
    if (playerInt == opponentInt) {
        return 3 + playerInt
    }

    if (playerInt - opponentInt == 1 || playerInt - opponentInt == -2) {
        return 6 + playerInt
    }
    return 0 + playerInt
}

fun readFile(): List<List<String>> {

    val text: List<List<String>> = File("day2/Input")
        .bufferedReader()
        .use { it.readText() }
        .split("\r\n")
        .map { it.split(" ") }

    return text
}

fun partA(text: List<List<String>>): Int {
    var score: Int = 0

    for (game in text) {
        score += round(game[0][0], game[1][0] - 23)
    }
    return score
}

fun partB(text: List<List<String>>): Int {
    var score: Int = 0

    for (game in text){
        if(game[1][0] == 'Y'){
            score += round(game[0][0], game[0][0])
        } else if (game[1][0] == 'X'){
            val temp: Int = game[0][0] - 'A'
            var losing = temp - 2
            if (losing < 0) {
                losing = 2
            }
            score += round(game[0][0], game[0][0]+losing)
        } else if (game[1][0] == 'Z'){
            val temp: Int = game[0][0] - 'A'
            var winning = temp + 1
            if (winning > 2) {
                winning = 0
            }
            score += round(game[0][0], 'A'+winning)
        }
    }

    return score
}