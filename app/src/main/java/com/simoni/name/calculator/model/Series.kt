package com.simoni.name.calculator.model

import android.content.Context
import androidx.compose.runtime.mutableStateOf

class Series(){
    var number = mutableStateOf("0")
    var memoria = mutableStateOf("0")
    var memoriaoper = mutableStateOf("0")
    var memoriaoperbool = mutableStateOf(false)


    fun append(char : String){
        if(memoriaoperbool.value) {
            number.value = ""
            memoriaoperbool.value = false
        }

        if (char != ".") {
            if (number.value == "0")
                number.value = char
            else
                number.value = number.value + char
        }else{
            if(number.value == "0")
                number.value = "0"
            else if (number.value.contains("."))
                number.value = number.value
            else
                number.value = number.value + char
        }
    }

    fun oper(char : String){
        memoria.value = number.value
        memoriaoper.value = char
        memoriaoperbool.value = true
    }

    fun result(){
        when{
            memoriaoper.value == "+" -> number.value = (number.value.toDouble() + memoria.value.toDouble()).toString()
            memoriaoper.value == "-" -> number.value = (memoria.value.toDouble() - number.value.toDouble()).toString()
            memoriaoper.value == "x" -> number.value = (number.value.toDouble() * memoria.value.toDouble()).toString()
            memoriaoper.value == "/" -> number.value = (memoria.value.toDouble() / number.value.toDouble()).toString()
            else -> number.value = "0"
        }

        if(number.value.endsWith(".0"))
            number.value = number.value.substring(0, number.value.length - 2)

        //if (number.value.length > 9)
            //number.value = number.value.substring(0,9) + "..."
    }

    fun back() {
        val n = number.value.length
        if(n > 1)
            number.value = number.value.substring(0, n - 1)
        else if (n == 1)
            number.value = "0"
    }

    fun delete()  {
        number.value = "0"
        memoria.value = "0"
        memoriaoper.value = "0"
        memoriaoperbool.value = false
    }
}