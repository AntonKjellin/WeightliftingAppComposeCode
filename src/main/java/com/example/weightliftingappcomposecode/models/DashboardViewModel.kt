package com.example.weightliftingappcomposecode.models

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.weightliftingappcomposecode.dataclasses.AppUser
import com.example.weightliftingappcomposecode.dataclasses.Pass
import dev.kjellin.weightliftingapp3.data.DatabaseFirestore

class DashboardViewModel : ViewModel(){

    private lateinit var db : DatabaseFirestore

    val currentUser = mutableStateOf(AppUser())
    val passesFinished = mutableListOf<Pass>()

    fun loadUser() {
        db = DatabaseFirestore()
        db.getUserData {
            it.also { currentUser.value  = it }
        }
    }
}