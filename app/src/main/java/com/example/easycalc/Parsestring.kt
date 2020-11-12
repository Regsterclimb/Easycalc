package com.example.easycalc

import com.example.easycalc.Enums.OperationNums

interface parseString {

    fun nums(str: String): List<Double> {
        var firstnumber = "-"
        var startsubstring = 0
        if (str.first() == '-') {
            for (i in 1 until str.length) {
                if (listOf('+', '×', '÷', '-').contains(str[i])) {
                    startsubstring = i
                    break
                }
                firstnumber += str[i]
            }
            return listOf(firstnumber.replace(',','.').toDouble()) + str.substring(startsubstring + 1, str.length)
                .replace(',','.')
                .split("+", "×", "÷", "-").map { it.toDouble() }
        }
        return str.split("+", "×", "÷", "-").map { it.toDouble() }
    }

    fun operators(str: String): String {
        if (str.first() == '-') {
            return str.substring(1, str.length).filter { it !in ('0'..'9') }
        }
        return str.filter { it !in ('0'..'9') &&  it != '.' }
    }

    fun charOptoStr(char1: Char): String {
        return when (char1) {
            '+' -> "Add"
            '-' -> "Dec"
            '×' -> "Times"
            '÷' -> "Div"
            else -> "wrong char"
        }
    }

    fun getEnumByItName(enumname:String): OperationNums? {
        return OperationNums.values().find { it.name == enumname }
    }

}