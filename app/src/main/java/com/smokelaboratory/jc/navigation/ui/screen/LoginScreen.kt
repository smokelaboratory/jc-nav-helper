package com.smokelaboratory.jc.navigation

import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun LoginScreen(onClick: () -> Unit) {

    Scaffold {
        Button(onClick = { onClick.invoke() }) {
            Text("Go to sign up")
        }
    }

}