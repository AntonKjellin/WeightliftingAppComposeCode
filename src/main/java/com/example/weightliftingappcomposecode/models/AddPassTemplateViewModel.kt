package com.example.weightliftingappcomposecode.models

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.weightliftingappcomposecode.dataclasses.Exercise
import com.example.weightliftingappcomposecode.dataclasses.ExerciseSet

class AddPassTemplateViewModel : ViewModel() {
    var passTemplateNameState= mutableStateOf("")
    var exercisesState = mutableStateListOf(Exercise("",ArrayList<ExerciseSet>()))
}