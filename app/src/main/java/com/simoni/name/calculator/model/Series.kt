package com.simoni.name.calculator.model

import android.content.Context
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.*

class Series(){
    var number = mutableStateOf("0")
    var memoria = mutableStateOf("0")
    var memoriaoper = mutableStateOf("0")
    var memoriaoperbool = mutableStateOf(false)
    var history = mutableStateListOf<String>()
    var historytmp = mutableStateOf("")


    fun append(char : String) {
        if (memoriaoperbool.value) {
            number.value = "0"
            memoriaoperbool.value = false
        }

        if (historytmp.value != "") {
            if(char != ".")
                number.value = "0"
            history.add(historytmp.value)
            //history.value!!.add(historytmp.value)
            historytmp.value = ""
        }

        if (char != ".") {
            if (number.value == "0")
                number.value = char
            else
                number.value = number.value + char
        } else {
            if (number.value.contains("."))
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
        history.add(memoria.value+memoriaoper.value+number.value)
        //history.value!!.add(memoria.value+memoriaoper.value+number.value)

        when{
            memoriaoper.value == "+" -> number.value = (number.value.toDouble() + memoria.value.toDouble()).toString()
            memoriaoper.value == "-" -> number.value = (memoria.value.toDouble() - number.value.toDouble()).toString()
            memoriaoper.value == "x" -> number.value = (number.value.toDouble() * memoria.value.toDouble()).toString()
            memoriaoper.value == "/" -> number.value = (memoria.value.toDouble() / number.value.toDouble()).toString()
            else -> number.value = "0"
        }

        if(number.value.endsWith(".0"))
            number.value = number.value.substring(0, number.value.length - 2)

        historytmp.value = number.value
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