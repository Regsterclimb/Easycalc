package com.example.easycalc.Enums

enum class DeleteOnClickOp { // Del operations
    Delall {
        override fun delresult(str: String): String {
            return "0"
        }

    },
    Dellast {
        override fun delresult(str: String): String {
            if (str.length==1){
                return when (str){
                    "0"-> str
                    else -> "0"
                }
            }
            return str.substring(0, str.length - 1)
        }
    };

    abstract fun delresult(str: String): String
}