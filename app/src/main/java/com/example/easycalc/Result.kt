package com.example.easycalc

import com.example.easycalc.Enums.OperationNums
import java.lang.NumberFormatException
import java.util.*

class Result(private val string: String) : parseString {
    private var listNum1: MutableList<Double> = nums(string).toMutableList() // parsing string to list of Double
    private var listOp1: MutableList<Char> = operators(string).toMutableList() //split string  to string without nums

    fun getString(): String {
        return string
    }

    private fun uprHard(char1: Char, char2: Char) { // choose operator priority from two equals operations like ('*','/')
        val ind = if (listOp1.indexOf(char1) < listOp1.indexOf(char2)) char1 else char2
        val x = listOp1.indexOf(ind)
        val oper = charOptoStr(ind)
        val result = getEnumByItName(oper)!!.appl(listNum1[x], listNum1[x + 1]).toDouble()
        replace(x, result)
    }

    private fun uprEasy(char1: Char) { //one operation line priority
        val x = listOp1.indexOf(char1)
        val oper = charOptoStr(char1)
        val result = getEnumByItName(oper)!!.appl(listNum1[x], listNum1[x + 1]).toDouble()
        replace(x, result)
    }

    private fun replace(ind: Int, result: Double) { // simplify two nums and operator to one num
        listOp1.removeAt(ind)
        listNum1[ind] = result
        listNum1.removeAt(ind + 1)
    }

    private fun initPriorityhard(char1: Char, char2: Char) { // init uprHard
        while (listOp1.contains(char1) && listOp1.contains(char2)) {
            uprHard(char1, char2)
        }
    }

    private fun initeasy(char1: Char) { // init uprEasy
        while (listOp1.contains(char1)) {
            uprEasy(char1)
        }
    }

    fun result(): String { // get result
        if (listOp1.isEmpty()) return listNum1.joinToString()
        try {
            initPriorityhard('×', '÷')
        } catch (e: NumberFormatException) {
            return "div By Zero"
        }
        try {
            initeasy('÷')
        } catch (e: NumberFormatException) {
            return "div By Zero"
        }
        initeasy('×')
        initPriorityhard('+', '-')
        initeasy('+')
        initeasy('-')
        return resultformat(listNum1[0])
    }
}
