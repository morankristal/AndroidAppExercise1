package com.example.tictactoe.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GameResult(winner: String?, currentPlayer: String) {
    Text(
        text = winner?.let { if (it == "Draw") "It's a Draw!" else "Player $it Wins!" }
            ?: "Player $currentPlayer's Turn",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(16.dp),
        textAlign = TextAlign.Center
    )
}
