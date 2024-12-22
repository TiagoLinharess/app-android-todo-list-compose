package com.example.todolistcompose.features.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todolistcompose.ui.theme.TodoListComposeTheme

@Composable
fun HomeScreen(viewModel: HomeViewModel = HomeViewModel()) {
    TodoListComposeTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = MaterialTheme.colorScheme.background
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp)
                    .padding(horizontal = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = viewModel.title.value ?: "",
                    modifier = Modifier
                        .padding(innerPadding)
                        .wrapContentSize()
                )
                TextField(
                    value = viewModel.text.value,
                    onValueChange = { viewModel.text.value = it },
                    label = { Text(viewModel.textFieldHint.value ?: "") },
                    modifier = Modifier
                        .padding(innerPadding)
                )
                Button(
                    onClick = { viewModel.addTask() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Text(viewModel.addTaskTitle.value ?: "")
                }
                LazyColumn(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(viewModel.tasks) { task ->
                        Item(task, { taskTitle ->
                            viewModel.markAsDone(taskTitle)
                        }) { taskTitle ->
                            viewModel.deleteTask(taskTitle)
                        }
                    }
                }
            }
        }
    }
}