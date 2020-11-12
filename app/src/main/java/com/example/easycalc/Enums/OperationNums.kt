package com.example.easycalc.Enums

enum class OperationNums { // Operations with two nums
    Add {
        override fun appl(a: Double, b: Double): String = (a + b).toString()
    },
    Dec {
        override fun appl(a: Double, b: Double): String = (a - b).toString()
    },
    Times {
        override fun appl(a: Double, b: Double): String = (a * b).toString()
    },
    Div {
        override fun appl(a: Double, b: Double): String =
            if (b == 0.0) "div by Zero" else (a / b).toString()
    };

    abstract fun appl(a: Double, b: Double): String
}