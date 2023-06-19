package com.mad4n7.maddiceroller

class Dice (private val numSides: Int) {
    var rollsCount = 0

    fun roll(): Int {
        rollsCount += 1
        return (1..numSides).random()
    }
}