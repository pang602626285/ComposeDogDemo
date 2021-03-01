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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.bean.Dog
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.vm.MainVH

class MainActivity : AppCompatActivity() {
    private val mainVM by viewModels<MainVH>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }

    override fun onBackPressed() {
        if (mainVM.curDog != null) {
            mainVM.curDog = null
        } else {
            super.onBackPressed()
        }
    }

    // Start building your app here!
    @Composable
    fun MyApp() {

        Scaffold(modifier = Modifier.fillMaxWidth(),
            topBar = {

                TopAppBar(
                    title = {
                        Text("Select your favorite Dog!",color = Color.White)
                    }
                )
            }) {

            if (mainVM.curDog == null) {
                DogList { dog -> onDogClick(dog) }
            } else {
                DogDetail(dog = mainVM.curDog!!)
            }

        }

    }

    @Composable
    private fun DogList(onClick: (Dog) -> Unit) {
        mainVM.dataList.let {
            LazyColumn {
                items(it) { dog ->
                    DogItem(
                        dog = dog, modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onClick(dog) }
                    )
                }
            }
        }
    }

    private fun onDogClick(dog: Dog) {
        mainVM.curDog = dog
    }

    @Composable
    private fun DogDetail(dog: Dog) {
        Column {
            Image(
                painter = painterResource(id = dog.logoId),
                contentDescription = "Dog name is ${dog.name}",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().height(300.dp)
            )
            Text(text = dog.name, color = Color.Black, style = MaterialTheme.typography.h4)
            Text(text = "age:${dog.age}", color = Color.Black)
            Text(text = dog.detail, color = Color.Yellow)
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

    @Preview("Light Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun LightPreview() {
        MyTheme {
            MyApp()
        }
    }

    @Preview("Dark Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun DarkPreview() {
        MyTheme(darkTheme = true) {
            MyApp()
        }
    }
}
