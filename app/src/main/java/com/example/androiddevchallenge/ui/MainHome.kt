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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.bean.Dog
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.vm.MainVM

// Start building your app here!
@Composable
fun MainHome(mainVM: MainVM) {
    val snackbarHostState = SnackbarHostState()
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Select your favorite Dog!", color = Color.White)
                }
            )
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) {
        if (mainVM.curDog == null) {
            DogList(mainVM.dataList) { dog -> mainVM.curDog = dog }
        } else {
            DogDetail(dog = mainVM.curDog!!, snackbarHostState)
        }
    }
}

@Composable
private fun DogList(dataList: List<Dog>, onClick: (Dog) -> Unit) {
    dataList.let {
        LazyColumn {
            items(it) { dog ->
                DogItem(
                    dog = dog,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onClick(dog) }
                )
            }
        }
    }
}

@Composable
fun DogItem(dog: Dog, modifier: Modifier) {
    Card(modifier) {
        Row(modifier = Modifier.padding(5.dp)) {
            Image(
                painter = painterResource(id = dog.logoId),
                contentDescription = "Dog name is ${dog.name}",
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(100.dp)
                    .width(150.dp),
            )
            Column {
                Text(text = dog.name, color = Color.Black, style = MaterialTheme.typography.h4)
                Text(text = dog.detail, color = Color.Yellow)
            }
        }
    }
}

@Preview
@Composable
fun DogListPreview() {
    MyTheme {
        DogList(
            dataList = listOf(
                Dog("Lili", R.drawable.dog1, 1),
                Dog("Sasa", R.drawable.dog2, 2),
                Dog("Hali", R.drawable.dog3, 5),
                Dog("PeHa", R.drawable.dog4, 7),
                Dog("Mate", R.drawable.dog5, 3),
                Dog("Peny", R.drawable.dog6, 8),
                Dog("Huyi", R.drawable.dog7, 2),
                Dog("pety", R.drawable.dog8, 9),
                Dog("Wuli", R.drawable.dog9, 11),
                Dog("Jick", R.drawable.dog10, 8),
            ),
            onClick = { }
        )
    }
}

@Preview("Light Theme")
@Composable
fun LightPreview() {
    MyTheme {
        MainHome(MainVM())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MainHome(MainVM())
    }
}
