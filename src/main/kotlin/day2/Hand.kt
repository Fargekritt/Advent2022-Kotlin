package day2

enum class Hand(val value: Int) {
    Rock(1),
    Paper(2),
    Scissor(3);

    companion object {
        fun fromInt(value: Int) = Hand.values().first { it.value == value }
    }
}