package com.example.tictactoe.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GameBoard(
    board: Array<Array<String>>,
    onCellClick: (Int, Int) -> Unit
) {
    for (row in 0..2) {
        Row {
            for (col in 0..2) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .padding(4.dp)
                        .background(Color.LightGray, RoundedCornerShape(8.dp))
                        .clickable { onCellClick(row, col) },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = board[row][col],
                        fontSize = 32.sp
                    )
                }
            }
        }
    }
}
