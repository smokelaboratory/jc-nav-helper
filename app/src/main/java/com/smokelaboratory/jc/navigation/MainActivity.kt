package com.smokelaboratory.jc.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.smokelaboratory.jc.navigation.ui.theme.NaviationDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NaviationDemoTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Entry.route) {

        navigation(Entry.Login.route, Entry.route) {

            composable(Entry.Login.route) {
                LoginScreen {
                    navController.navigate(
                        Entry.Signup.address(
                            mapOf(
                                Entry.Signup.Arguments.EMAIL.name to "sumeetrukeja@gmail.com",
                                Entry.Signup.Arguments.PASSWORD.name to "123456",
                                Entry.Signup.OptionalArguments.BIRTH_DATE.name to "23-Sep-1994"
                            )
                        )
                    )
                }
            }

            composable(Entry.Signup.route) {
                SignupScreen(
                    it.arguments?.getString(Entry.Signup.Arguments.EMAIL.name).orEmpty(),
                    it.arguments?.getString(Entry.Signup.Arguments.PASSWORD.name).orEmpty(),
                    it.arguments?.getString(Entry.Signup.OptionalArguments.BIRTH_DATE.name)
                )
            }
        }
    }

    /*NavHost(navController = navController, startDestination = "entryModule") {

        navigation("login", "entryModule") {

            composable("login") {
                LoginScreen {
                    navController.navigate("signup/sumeetrukeja@gmail.com/123456?birthdate=23-Sep-1994")
                }
            }

            composable("signup/{email}/{password}?birthdate={birthdate}") {
                SignupScreen(
                    it.arguments?.getString("email").orEmpty(),
                    it.arguments?.getString("password").orEmpty(),
                    it.arguments?.getString("birthdate")
                )
            }
        }
    }*/
}