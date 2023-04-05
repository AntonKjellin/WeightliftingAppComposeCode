package com.example.weightliftingappcomposecode.models

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AddTemplateGroupViewModel : ViewModel() {

    var templateGroupName = mutableStateOf("")
}