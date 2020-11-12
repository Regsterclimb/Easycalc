package com.example.easycalc.keyboard

class Allkeyboardbuttons { // Array of Buttons
    private val array = arrayListOf(SimpleBut("0"),SimpleBut("1"), SimpleBut("2"), SimpleBut("3"),
        SimpleBut("4"), SimpleBut("5"), SimpleBut("6"), SimpleBut("7"), SimpleBut("8"),
        SimpleBut("9"),SimpleBut("00"), SimpleBut("+"),SimpleBut("-"),SimpleBut("×"),SimpleBut("÷")
    )

    fun getkeyboardbuttonsarray(): ArrayList<SimpleBut> {
        return array
    }
}

class SimpleBut(private val name: String) : KeyboardButton() {

    override fun getname(): String {
        return name
    }
}
