package com.example.easycalc

import com.example.easycalc.Enums.OperationNums
import org.junit.Assert.assertEquals
import org.junit.Test

class ResultTest {
    val result = Result("5+120×5+10÷5+250÷50-400+5×25")
    val result1 = Result("5+120×5+10÷5+250÷0-400+5×25")
    val result2 = Result("-1500000+50000000")
    val result3 = Result("-5+25-400+25-25-600-800-400+500000-4000000+100000000")

    @Test
    fun checkParseStringCharOpToString(){
        assertEquals("Add",result.charOptoStr('+'))
        assertEquals("Dec",result.charOptoStr('-'))
        assertEquals("Times",result.charOptoStr('×'))
        assertEquals("Div",result.charOptoStr('÷'))
    }
    @Test
    fun checkParseStringGetEnumByItName(){
        assertEquals(OperationNums.Add,result.getEnumByItName("Add"))
        assertEquals(OperationNums.Dec,result.getEnumByItName("Dec"))
        assertEquals(OperationNums.Times,result.getEnumByItName("Times"))
        assertEquals(OperationNums.Div,result.getEnumByItName("Div"))
    }

    @Test
    fun checkParseStringnums(){
        assertEquals(listOf(5,120,5,10,5,250,50,400,5,25),result.nums(result.getString()))
        assertEquals(listOf(-1500000,50000000),result2.nums(result2.getString()))
        assertEquals(listOf(-5,25,400,25,25,600,800,400,500000,4000000,100000000),result3.nums(result3.getString()))
    }

    @Test
    fun checkParseStringoperators(){
        assertEquals("+×+÷+÷-+×",result.operators(result.getString()))
        assertEquals("+",result2.operators(result2.getString()))
        assertEquals("+-+----+-+",result3.operators(result3.getString()))
    }

    @Test
    fun checkResult(){
        assertEquals("337", result.result())
        assertEquals("div By Zero",result1.result())
        assertEquals("48500000",result2.result())
        assertEquals("96497820",result3.result())
    }

}