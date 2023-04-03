package com.example.weightliftingappcomposecode.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.weightliftingappcomposecode.dataclasses.ExerciseSet

object Components {
    @Composable
    fun DynamicExerciseCard(exercise: ArrayList<ExerciseSet>?){
        var array = arrayOf(exercise)

        Column(modifier = Modifier.padding(all = 8.dp)) {

            Row {
                LabelAndPlaceHolder("Exercise Name",150, 60)
            }

            LazyRow {
                items(array){
                    DynamicSetCard()
                }
            }
        }
    }


    @Composable
    fun DynamicSetCard(){
        Column {
            LabelAndPlaceHolder(placeholder = "85", width = 60, height = 60)
            LabelAndPlaceHolder( placeholder = "5", width = 60, height = 60)
        }
    }


    @Composable
    fun LabelAndPlaceHolder(placeholder : String, width : Int, height: Int) {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            modifier = Modifier
                .width(width.dp)
                .height(height.dp),
            placeholder = { Text(text = placeholder) },
        )
    }



}
