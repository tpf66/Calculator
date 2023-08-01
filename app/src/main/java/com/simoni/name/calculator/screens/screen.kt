package com.simoni.name.calculator.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simoni.name.calculator.model.Series
import com.simoni.name.calculator.ui.theme.second
import com.simoni.name.calculator.ui.theme.third

@Composable
fun screen(
    size: Dp,
    series: Series
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        contentAlignment = Alignment.BottomEnd
    ){
        Text(
            text = series.number.value,
            fontSize = 60.sp,
            color = third,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}