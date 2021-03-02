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