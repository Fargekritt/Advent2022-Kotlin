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


    println(partA(readFile()))
    println(partB(readFile()))
}

fun round(opponent: Hand, player: Hand): Int {
    val opponentInt = opponent.value
    val playerInt = player.value
    if (playerInt == opponentInt) {
        return 3 + playerInt
    }

    if (playerInt - opponentInt == 1 || playerInt - opponentInt == -2) {
        return 6 + playerInt
    }
    return 0 + playerInt
}

fun readFile(): List<List<String>> {

    val text: List<List<String>> =
        File("day2/Input").bufferedReader().use { it.readText() }.split("\r\n").map { it.split(" ") }

    return text
}

fun partA(text: List<List<String>>): Int {
    var score: Int = 0

    for (game in text) {
        val opponent: Hand = Hand.fromInt(game[0][0] - 'A' + 1)
        val player: Hand = Hand.fromInt(game[1][0] - 'X' + 1)
        score += round(opponent, player)
    }
    return score
}

fun partB(text: List<List<String>>): Int {
    var score: Int = 0

    //Y = Draw
    //X = Lose
    //Z = Win
    for (game in text) {
        val opponent: Hand = Hand.fromInt(game[0][0] - 'A' + 1)
        var player: Hand = Hand.Rock
        if (game[1][0] == 'Y') {
            player = opponent
        } else if (game[1][0] == 'X') {
            var test = (game[0][0] - 'A' + 3) % 3
            if (test == 0) test = 3
            player = Hand.fromInt(test)
        } else if (game[1][0] == 'Z') {
            var test = (game[0][0] - 'A' + 2) % 3
            if (test == 0) test = 3
            player = Hand.fromInt(test)
        }
        score += round(opponent, player)
    }

    return score
}