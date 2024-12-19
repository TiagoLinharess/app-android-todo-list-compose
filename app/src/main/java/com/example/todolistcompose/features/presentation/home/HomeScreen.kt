package com.example.todolistcompose.features.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todolistcompose.ui.theme.TodoListComposeTheme

@Composable
fun HomeScreen() {
    TodoListComposeTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = MaterialTheme.colorScheme.background
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(top = 16.dp)
            ) {
                Text(
                    text = "To Do List",
                    modifier = Modifier
                        .padding(innerPadding)
                        .align(Alignment.TopCenter)
                        .wrapContentSize()
                )
            }
        }
    }
}