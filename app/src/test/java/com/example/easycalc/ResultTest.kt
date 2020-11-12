package com.example.easycalc

import com.example.easycalc.Enums.OperationNums
import org.junit.Assert.assertEquals
import org.junit.Test

class ResultTest {
    val result = Result("5+120×5+10÷5+250÷50-400+5×25")
    val result1 = Result("5+120×5+10÷5+250÷0-400+5×25")
    val result2 = Result("-1500000+50000000")
    val result3 = Result("-5+25-400+25-25-600-800-400+500000-4000000+100000000")
    val result4 = Result("55÷3")
    val result5 = Result("18.333333÷3")

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
        assertEquals(listOf(5.0,120.0,5.0,10.0,5.0,250.0,50.0,400.0,5.0,25.0),result.nums(result.getString()))
        assertEquals(listOf(-1500000.0,50000000.0),result2.nums(result2.getString()))
        assertEquals(listOf(-5.0,25.0,400.0,25.0,25.0,600.0,800.0,400.0,500000.0,4000000.0,100000000.0),result3.nums(result3.getString()))
        assertEquals(listOf(18.333333,3.0),result5.nums(result5.getString()))
    }

    @Test
    fun checkParseStringoperators(){
        assertEquals("+×+÷+÷-+×",result.operators(result.getString()))
        assertEquals("+",result2.operators(result2.getString()))
        assertEquals("+-+----+-+",result3.operators(result3.getString()))
        assertEquals("÷",result5.operators(result5.getString()))
    }

    @Test
    fun checkResult(){
        assertEquals("337", result.result())
        assertEquals("div By Zero",result1.result())
        assertEquals("48500000",result2.result())
        assertEquals("96497820",result3.result())
        assertEquals("18.333333",result4.result())
        assertEquals("6.111111",result5.result())
    }

}