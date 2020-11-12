package com.example.easycalc

class Resultformat(private val doubletostring:Double) {

    private fun resultformat(double: Double): String {
        if (verylow(double)){
            return String.format("%.2e", double)
        }
        if (isWhole(double)){
            return double.toInt().toString()
        }
        else {
            return String.format("%f", double)
        }
    }

    private fun isWhole(value: Double):Boolean {
        return value - value.toInt() == 0.0
    }

    private fun verylow(value: Double): Boolean {
        return value <0.000001
    }

    fun getformat(): String {
        return resultformat(doubletostring)
    }
}