package com.simoni.name.calculator.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simoni.name.calculator.model.Series
import com.simoni.name.calculator.ui.theme.third

@Composable
fun Screen(
    series: Series
){
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomEnd
    ){
        Text(
            text = series.number.value,
            fontSize = 50.sp,
            color = third,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
@Composable
fun Secondscreen(
    series: Series,
    state: LazyListState
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)
            .border(4.dp, third, RoundedCornerShape(15.dp)),
        contentAlignment = Alignment.BottomEnd
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 15.dp),
            userScrollEnabled = true,
            state = state
        ) {
            //itemsIndexed(series.history.value!!) { index, it ->
            itemsIndexed(series.history) { index, it ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = it,
                        fontSize = 30.sp,
                        color = third,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}