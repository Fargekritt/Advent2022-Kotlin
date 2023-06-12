package day2

enum class Hand(val value: Int) {
    Rock(0),
    Paper(1),
    Scissor(2);

    companion object {
        fun fromInt(value: Int) = Hand.values().first { it.value == value }
    }
}