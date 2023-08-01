package com.simoni.name.calculator.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simoni.name.calculator.R
import com.simoni.name.calculator.ui.theme.CalculatorTheme
import com.simoni.name.calculator.ui.theme.second
import com.simoni.name.calculator.ui.theme.third

@Composable
fun button(
    char: String,
    onClick: () -> Unit = {}
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(100.dp)
            .padding(5.dp)
    ) {
        Icon(
            modifier = Modifier
                .fillMaxSize()
                .padding(7.dp)
                .background(second, shape = MaterialTheme.shapes.small),
            imageVector = when {
                char == "1" -> ImageVector.vectorResource(id = R.drawable.one)
                char == "2" -> ImageVector.vectorResource(id = R.drawable.two)
                char == "3" -> ImageVector.vectorResource(id = R.drawable.three)
                char == "4" -> ImageVector.vectorResource(id = R.drawable.four)
                char == "5" -> ImageVector.vectorResource(id = R.drawable.five)
                char == "6" -> ImageVector.vectorResource(id = R.drawable.six)
                char == "7" -> ImageVector.vectorResource(id = R.drawable.seven)
                char == "8" -> ImageVector.vectorResource(id = R.drawable.eight)
                char == "9" -> ImageVector.vectorResource(id = R.drawable.nine)
                char == "0" -> ImageVector.vectorResource(id = R.drawable.zero)
                char == "+" -> ImageVector.vectorResource(id = R.drawable.plus)
                char == "-" -> ImageVector.vectorResource(id = R.drawable.minus)
                char == "/" -> ImageVector.vectorResource(id = R.drawable.divide)
                char == "x" -> ImageVector.vectorResource(id = R.drawable.x)
                char == "=" -> ImageVector.vectorResource(id = R.drawable.equals)
                char == "." -> ImageVector.vectorResource(id = R.drawable.dot)
                char == "d" -> ImageVector.vectorResource(id = R.drawable.doubleleft)
                char == "b" -> ImageVector.vectorResource(id = R.drawable.left)
                else -> ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground)
            },
            contentDescription = char,
            tint = third,
        )
    }
}

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val char = "."
    CalculatorTheme {
        button(char = char)
    }
}*/