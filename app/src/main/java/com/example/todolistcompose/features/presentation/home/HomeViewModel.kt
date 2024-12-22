package com.example.todolistcompose.features.presentation.home

import androidx.compose.animation.core.copy
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolistcompose.features.domain.model.Task

class HomeViewModel : ViewModel() {
    private val _title = MutableLiveData<String>().apply {
        value = "To Do List"
    }
    val title: LiveData<String> = _title

    private val _textFieldHint = MutableLiveData<String>().apply {
        value = "Enter a task"
    }
    val textFieldHint: LiveData<String> = _textFieldHint

    private val _addTaskTitle = MutableLiveData<String>().apply {
        value = "Add Task"
    }
    val addTaskTitle: LiveData<String> = _addTaskTitle

    private val _text = mutableStateOf("")
    val text: MutableState<String> = _text

    private val _tasks = mutableStateListOf<Task>()
    val tasks: MutableList<Task> = _tasks

    fun addTask() {
        if (text.value.isEmpty() || tasks.any { it.title == text.value }) { return }
        val task = Task(text.value, false)
        tasks.add(task)
    }

    fun markAsDone(title: String) {
        val index = tasks.indexOfFirst { it.title == title }
        if (index != -1) {
            tasks[index] = tasks[index].copy(isDone = !tasks[index].isDone)
        }
    }

    fun deleteTask(title: String) {
        val index = tasks.indexOfFirst { it.title == title }
        if (index != -1) {
            tasks.removeAt(index)
        }
    }
}