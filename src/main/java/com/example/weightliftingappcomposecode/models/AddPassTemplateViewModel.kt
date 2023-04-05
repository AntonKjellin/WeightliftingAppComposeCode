package com.example.weightliftingappcomposecode.models

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.weightliftingappcomposecode.dataclasses.Exercise
import com.example.weightliftingappcomposecode.dataclasses.ExerciseSet

class AddPassTemplateViewModel : ViewModel() {
    var passTemplateName= mutableStateOf("")
    var exercises = mutableListOf(Exercise())
    var sets = mutableListOf(ExerciseSet())


}