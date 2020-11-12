package com.example.easycalc

interface Gresultformat {
    fun getResultFormat(double: Double): String {
        return Resultformat(double).getformat()
    }
}