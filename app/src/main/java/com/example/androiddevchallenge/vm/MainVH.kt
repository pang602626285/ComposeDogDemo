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
package com.example.androiddevchallenge.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.bean.Dog

class MainVH : ViewModel() {
    var curDog: Dog? by mutableStateOf(null)

    val dataList by mutableStateOf(
        listOf(
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
        )
    )
}
