package com.example.weightliftingappcomposecode.models

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.weightliftingappcomposecode.auth.FirebaseAuthService

class LoginViewModel : ViewModel() {
    private lateinit var fas : FirebaseAuthService

    var emailState = mutableStateOf("")
    var passwordState = mutableStateOf("")

    fun login(){
        fas.loginUser(emailState.value,passwordState.value){
            if (it){
                TODO("Make Navigation First")
            } else {
                TODO("Make error handling")
            }
        }
    }

}