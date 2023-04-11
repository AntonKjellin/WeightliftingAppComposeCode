package com.example.weightliftingappcomposecode.models

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AddPassViewModel : ViewModel() {
    var passName = mutableStateOf("")
}