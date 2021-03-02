package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.example.androiddevchallenge.bean.Dog
import com.example.androiddevchallenge.vm.MainVH
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.theme.MyTheme

// Start building your app here!
@Composable
fun MainHome() {
    val snackbarHostState = SnackbarHostState()
    val mainVM = viewModel<MainVH>()
    Scaffold(modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Select your favorite Dog!", color = Color.White)
                }
            )
        }, snackbarHost = { SnackbarHost(hostState = snackbarHostState) }) {
        if (mainVM.curDog == null) {
            DogList { dog -> mainVM.curDog = dog }
        } else {
            DogDetail(dog = mainVM.curDog!!, snackbarHostState)
        }

    }

}

@Composable
private fun DogList(onClick: (Dog) -> Unit) {
    val mainVM = viewModel<MainVH>()
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
        MainHome()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MainHome()
    }
}