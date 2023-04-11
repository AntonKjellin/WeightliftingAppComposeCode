package com.example.weightliftingappcomposecode.models

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.weightliftingappcomposecode.dataclasses.TemplateGroup

class AddTemplateGroupViewModel : ViewModel() {
    var templateGroupName = mutableStateOf("")
    fun addGroup(name: TemplateGroup){

    }
}