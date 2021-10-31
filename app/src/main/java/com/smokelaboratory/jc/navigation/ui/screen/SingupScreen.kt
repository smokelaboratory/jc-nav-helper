package com.smokelaboratory.jc.navigation

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SignupScreen(email: String, password: String, birthdate: String?) {

    Scaffold {
        Text(
            "Email : $email \n" +
                    "Password : $password \n" +
                    "Birthdate : $birthdate"
        )
    }

}