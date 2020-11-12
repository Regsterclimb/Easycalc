package com.example.easycalc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import com.example.easycalc.Enums.DeleteOnClickOp
import com.example.easycalc.keyboard.Allkeyboardbuttons
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                if (textView.text.toString().substring(textView.text.length-1, textView.text.length) == "÷0"){
                    textView.text = "На ноль делить нельзя"
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })

        button0.setOnClickListener(::keyboardOnClick)
        button1.setOnClickListener(::keyboardOnClick)
        button2.setOnClickListener(::keyboardOnClick)
        button3.setOnClickListener(::keyboardOnClick)
        button4.setOnClickListener(::keyboardOnClick)
        button5.setOnClickListener(::keyboardOnClick)
        button6.setOnClickListener(::keyboardOnClick)
        button7.setOnClickListener(::keyboardOnClick)
        button8.setOnClickListener(::keyboardOnClick)
        button9.setOnClickListener(::keyboardOnClick)
        buttonDelall.setOnClickListener(::Deletesome)
        buttonDellast.setOnClickListener(::Deletesome)
        buttonAdd.setOnClickListener(::keyboardoperationsOnClick)
        buttonDiv.setOnClickListener(::keyboardoperationsOnClick)
        buttonDec.setOnClickListener(::keyboardoperationsOnClick)
        buttonTimes.setOnClickListener(::keyboardoperationsOnClick)
        buttonEquals.setOnClickListener(::catcherror)

    }
    private fun equaliss(v:View) {
        val text =textView.text.toString()
        if (listOf('+', '×', '÷', '-').contains(textView.text[textView.text.lastIndex])){
            textView.text =Result(text.substring(0,text.length-1)).getresult()
        }
        else {
            textView.text =Result(textView.text.toString()).getresult()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun keyboardOnClick(v:View) {
        val keyboradlist = Allkeyboardbuttons().getkeyboardbuttonsarray()
        Log.d("Tag", "${v.tag}")
        val x = keyboradlist.find { it.getname()==v.tag }!!.getname()
        if (textView.text.toString() == "0"|| textView.text.toString() =="На ноль делить нельзя"){
            textView.text =x
        }
        else {
            textView.text = textView.text.toString() + x
        }
    }

    @SuppressLint("SetTextI18n")
    private fun keyboardoperationsOnClick(v:View) {
        val keyboradlist = Allkeyboardbuttons().getkeyboardbuttonsarray()
        val x = keyboradlist.find { it.getname()==v.tag }!!.getname()
        val text =textView.text.toString()
        Log.d("Tag", "${v.tag}")
        if (listOf('+', '×', '÷', '-').contains(text[text.lastIndex])){
            textView.text = text.substring(0,text.length-1) + x
        }
        else textView.text = textView.text.toString() + x
    }

    private fun Deletesome(v:View){
        textView.text = DeleteOnClickOp.values().find{it.name == v.tag}!!.delresult(textView.text.toString())
    }
    fun catcherror(v:View) {
        try{
            equaliss(buttonEquals)
            equaliss(buttonEquals)
        }
        catch (e:NumberFormatException) {
            textView.text = "Ошибка"
        }
    }
    


}
