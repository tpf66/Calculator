package com.simoni.name.calculator.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simoni.name.calculator.model.Series
import com.simoni.name.calculator.ui.theme.first
import com.simoni.name.calculator.ui.theme.second
import com.simoni.name.calculator.ui.theme.third
import kotlinx.coroutines.launch

@Composable
fun MainView(series: Series) {
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
    val state = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(first),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Secondscreen(series,state)
            Screen(series)
        }
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
                button(char = "d", series) {
                    series.delete()
                    coroutineScope.launch { state.animateScrollToItem(series.history.size) }
                }
                button(char = "b", series) {
                    series.back()
                    coroutineScope.launch { state.animateScrollToItem(series.history.size) }
                }
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                button("1", series) {
                    series.append("1")
                    coroutineScope.launch { state.animateScrollToItem(series.history.size) }
                }
                button("2", series) {
                    series.append("2")
                    coroutineScope.launch { state.animateScrollToItem(series.history.size) }
                }
                button("3", series) {
                    series.append("3")
                    coroutineScope.launch { state.animateScrollToItem(series.history.size) }
                }
                button("/", series) {
                    series.oper("/")
                }
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                button("4", series) { series.append("4")
                    coroutineScope.launch { state.animateScrollToItem(series.history.size) }
                }
                button("5", series) { series.append("5")
                    coroutineScope.launch { state.animateScrollToItem(series.history.size) }
                }
                button("6", series) { series.append("6")
                    coroutineScope.launch { state.animateScrollToItem(series.history.size) }
                }
                button("x", series) { series.oper("x") }
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                button("7", series) {
                    series.append("7")
                    coroutineScope.launch { state.animateScrollToItem(series.history.size) }
                }
                button("8", series) {
                    series.append("8")
                    coroutineScope.launch { state.animateScrollToItem(series.history.size) }
                }
                button("9", series) {
                    series.append("9")
                    coroutineScope.launch { state.animateScrollToItem(series.history.size) }
                }
                button("-", series) { series.oper("-") }
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                button("0", series) {
                    series.append("0")
                    coroutineScope.launch { state.animateScrollToItem(series.history.size) }
                }
                button(".", series) {
                    series.append(".")
                    coroutineScope.launch { state.animateScrollToItem(series.history.size) }
                }
                button("=", series) {
                    series.result()
                    coroutineScope.launch { state.animateScrollToItem(series.history.size) }
                }
                button("+", series) { series.oper("+") }
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
                button("1", series) { series.append("1") }
                button("2", series) { series.append("2") }
                button("3", series) { series.append("3") }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                button("4", series) { series.append("4") }
                button("5", series) { series.append("5") }
                button("6", series) { series.append("6") }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                button("7", series) { series.append("7") }
                button("8", series) { series.append("8") }
                button("9", series) { series.append("9") }
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Screen(series)

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
                    button("+", series) { series.oper("+") }
                    button("-", series) { series.oper("-") }
                    button("d", series) { series.delete() }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    button("0", series) { series.append("0") }
                    button(".", series) { series.append(".") }
                    button("=", series) { series.result() }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    var series by remember { mutableStateOf(Series()) }
    portrait(series = series)
}