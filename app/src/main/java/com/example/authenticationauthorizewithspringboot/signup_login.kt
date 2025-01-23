package com.example.authenticationauthorizewithspringboot

import android.util.Log
import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun SignUp(viewModel: UserViewModel,onLoginClick: () -> Unit) {
    val userState by viewModel.userState.collectAsState()

    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hey! SignUp Please..")
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if(name.isNotEmpty() && password.isNotEmpty()){
                  viewModel.getUser(name)
                }else{
                    Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        ) {
            Text("SignUp..")
        }
//        when(Result){
//          is Result.Success -> Text("SignUp Success")
//           is Result.Failure -> Text("SignUp Failure")
//
//        }
        Spacer(modifier = Modifier.height(39.dp))
        Text(
            text = "Already have an account? Login",
            color = Color.Blue,
            modifier = Modifier.clickable { onLoginClick() }
        )
    }
}

@Composable
fun LogIn(viewModel: UserViewModel,onSignUpClick: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val userState by viewModel.userState.collectAsState()
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hey! LogIn Please..")
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
             onClick = {
                 if (name.isNotEmpty() && password.isNotEmpty()){
                   viewModel.updateUser(name, User(id = 0, name = name, password = password))
                 }
                 else Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT)
                     .show()
             }
        ) {
            Text("Login..")
        }
//        when(userState){
//            is Result.Success -> Text("Login Success")
//            is Result.Failure -> Text("Login Failure")
//        }
        Spacer(modifier = Modifier.height(39.dp))
        Text(
            text = "Don't have an account? Sign Up",
            color = Color.Blue,
            modifier = Modifier.clickable { onSignUpClick() }
        )
    }
}