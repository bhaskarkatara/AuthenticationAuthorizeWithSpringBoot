package com.example.authenticationauthorizewithspringboot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.authenticationauthorizewithspringboot.ui.theme.AuthenticationAuthorizeWithSpringBootTheme
import networlCall.RetrofitInstance

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AuthenticationAuthorizeWithSpringBootTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Main(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
// method for handling signup.login
@Composable
fun Main(modifier: Modifier = Modifier) {
    var isSignUpScreen by remember { mutableStateOf(true) } // State to toggle between SignUp and LogIn
    val userRepository = UserRepository(apiService = RetrofitInstance.api)
    val viewModel = UserViewModel(userRepository = userRepository)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isSignUpScreen) {
            SignUp(viewModel,onLoginClick = { isSignUpScreen = false })
        } else {
            LogIn(viewModel,onSignUpClick = { isSignUpScreen = true })
        }
    }
}

