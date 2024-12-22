package com.example.todolistcompose.features.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolistcompose.features.domain.model.Task

@Composable
fun Item(task: Task, onClick: (String) -> Unit, onDelete: (String) -> Unit) {
    Row(
        modifier = Modifier
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = MaterialTheme.shapes.medium
            )
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onClick(task.title) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = task.title,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(10.dp),
            color = MaterialTheme.colorScheme.primary,
            style = TextStyle(
                textDecoration = if (task.isDone) TextDecoration.LineThrough else null
            )
        )
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Box(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = MaterialTheme.shapes.medium
                )
        ) {
            Icon(
                imageVector = Icons.Outlined.Done,
                "icon",
                modifier = Modifier
                    .padding(2.dp)
                    .alpha(if (task.isDone) 1f else 0f),
                tint = MaterialTheme.colorScheme.primary
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Icon(
            imageVector = Icons.Outlined.Delete,
            "icon",
            modifier = Modifier
                .size(30.dp)
                .clickable { onDelete(task.title) },
            tint = MaterialTheme.colorScheme.error
        )
    }
}