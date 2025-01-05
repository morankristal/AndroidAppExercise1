package com.example.tictactoe.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tictactoe.ui.components.GameBoard
import com.example.tictactoe.ui.components.GameResult

@Composable
fun TicTacToeGame() {
    var board by remember { mutableStateOf(Array(3) { Array(3) { "" } }) }
    var currentPlayer by remember { mutableStateOf("X") }
    var winner by remember { mutableStateOf<String?>(null) }

    fun resetGame() {
        board = Array(3) { Array(3) { "" } }
        currentPlayer = "X"
        winner = null
    }

    fun checkWinner(): String? {
        for (i in 0..2) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0].isNotEmpty())
                return board[i][0]
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i].isNotEmpty())
                return board[0][i]
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0].isNotEmpty())
            return board[0][0]
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2].isNotEmpty())
            return board[0][2]

        if (board.all { row -> row.all { it.isNotEmpty() } }) return "Draw"
        return null
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        GameResult(winner = winner, currentPlayer = currentPlayer)

        Spacer(modifier = Modifier.height(16.dp))

        GameBoard(
            board = board,
            onCellClick = { row, col ->
                if (board[row][col].isEmpty() && winner == null) {
                    board[row][col] = currentPlayer
                    winner = checkWinner()
                    if (winner == null) {
                        currentPlayer = if (currentPlayer == "X") "O" else "X"
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { resetGame() }) {
            Text(text = "Reset Game")
        }
    }
}
