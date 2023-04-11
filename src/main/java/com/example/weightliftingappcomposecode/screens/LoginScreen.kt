package com.example.weightliftingappcomposecode.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weightliftingappcomposecode.models.LoginViewModel
import com.example.weightliftingappcomposecode.ui.theme.WeightliftingAppComposeCodeTheme


@Preview(showBackground = true)
@Composable
fun ScreenPreview(){
        LoginScreen()
}

@Composable
fun LoginScreen(){
        val vm = LoginViewModel()

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(1.0f))

            Column(
                modifier = Modifier.align(CenterHorizontally)
            ) {
                EmailField(vm.emailState)
                PasswordField(vm.passwordState)
                Button(
                    onClick = {
                        Log.i(
                            "PIA11Debug",
                            vm.emailState.toString() + " : " + vm.passwordState.toString()
                        )
                    },
                    modifier = Modifier
                        .widthIn(120.dp, 300.dp)
                        .align(CenterHorizontally)
                ) {
                    Text(text = "Login")
                }
                Text(modifier = Modifier
                    .align(CenterHorizontally)
                    .clickable { }, text = "Already got an account? Click here!"
                )
            }
            Spacer(modifier = Modifier.weight(2.0f))
        }
}

@Composable
fun EmailField(emailState : MutableState<String>) {

    OutlinedTextField(
        value = emailState.value,
        modifier = Modifier.widthIn(0.dp,300.dp),
        leadingIcon = { Icon(imageVector = Icons.Rounded.Email, contentDescription = "emailIcon") },
        onValueChange = {
            emailState.value = it
        },
        label = { Text(text = "Email") },
        placeholder = { Text(text = "Enter Email Here") },
    )
}

@Composable
fun PasswordField(passwordState: MutableState<String>) {

    OutlinedTextField(
        value = passwordState.value,
        modifier = Modifier.widthIn(0.dp,300.dp),
        leadingIcon = { Icon(imageVector = Icons.Rounded.Lock, contentDescription = "passwordIcon") },
        onValueChange = {
            passwordState.value = it
        },
        label = { Text(text = "Password") },
        placeholder = { Text(text = "Enter Password Here") },
    )
}
