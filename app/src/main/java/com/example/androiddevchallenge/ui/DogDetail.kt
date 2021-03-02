package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.bean.Dog
import kotlinx.coroutines.launch

@Composable
fun DogDetail(dog: Dog, snackbarHostState: SnackbarHostState) {
    val scope = rememberCoroutineScope()
    Column {
        Image(
            painter = painterResource(id = dog.logoId),
            contentDescription = "Dog name is ${dog.name}",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        Text(text = dog.name, color = Color.Black, style = MaterialTheme.typography.h4)
        Text(text = "age:${dog.age}", color = Color.Black)
        Text(text = dog.detail, color = Color.Yellow)
        Button(onClick = { scope.launch { snackbarHostState.showSnackbar(message = "Adopt ${dog.name} success!") } }) {
            Text(text = "Adopt")
        }
    }
}
