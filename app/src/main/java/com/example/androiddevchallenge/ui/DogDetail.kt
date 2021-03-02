/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
