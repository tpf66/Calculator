package com.simoni.name.calculator.screens

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simoni.name.calculator.R
import com.simoni.name.calculator.model.Series
import com.simoni.name.calculator.ui.theme.CalculatorTheme
import com.simoni.name.calculator.ui.theme.first
import com.simoni.name.calculator.ui.theme.second
import com.simoni.name.calculator.ui.theme.third

@Composable
fun MainView(series: Series){
    val configuration = LocalConfiguration.current

    when (configuration.orientation) {
        Configuration.ORIENTATION_PORTRAIT -> {
           portrait(series)
        }
        else -> {
            landscape(series)
        }
    }
}


@Composable
fun portrait(series: Series) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(first),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        screen(300.dp, series)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Row() {

                Spacer(modifier = Modifier.size(100.dp))
                Spacer(modifier = Modifier.size(100.dp))
                button(char = "d", {series.delete()})
                button(char = "b", {series.back()})
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                button("1", {series.append("1")})
                button("2", {series.append("2")})
                button("3", {series.append("3")})
                button("/", {series.oper("/")})
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                button("4", {series.append("4")})
                button("5", {series.append("5")})
                button("6", {series.append("6")})
                button("x", {series.oper("x")})
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                button("7", {series.append("7")})
                button("8", {series.append("8")})
                button("9", {series.append("9")})
                button("-", {series.oper("-")})
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                button("0", {series.append("0")})
                button(".", {series.append(".")})
                button("=", {series.result()})
                button("+", {series.oper("+")})
            }
        }
    }
}


@Composable
fun landscape(series: Series) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(first)
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.5f)
                .border(4.dp, third, RoundedCornerShape(15.dp)),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                button("1", {series.append("1")})
                button("2", {series.append("2")})
                button("3", {series.append("3")})
            }
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                button("4", {series.append("4")})
                button("5", {series.append("5")})
                button("6", {series.append("6")})
            }

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                button("7", {series.append("7")})
                button("8", {series.append("8")})
                button("9", {series.append("9")})
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            screen(300.dp, series)

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    button("+", {series.oper("+")})
                    button("-", {series.oper("-")})
                    button("d", {series.delete()})
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    button("0", {series.append("0")})
                    button(".", {series.append(".")})
                    button("=", {series.result()})
                }
            }
        }
    }
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    var series by remember { mutableStateOf(Series()) }
        landscape(series = series)
}