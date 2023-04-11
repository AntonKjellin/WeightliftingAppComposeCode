package com.example.weightliftingappcomposecode.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weightliftingappcomposecode.dataclasses.Exercise
import com.example.weightliftingappcomposecode.dataclasses.ExerciseSet
import com.example.weightliftingappcomposecode.models.AddPassTemplateViewModel

@Preview(showBackground = true)
@Composable
fun AddPreview(){
    AddTemplateScreen()
}

val vm = AddPassTemplateViewModel()
@Composable
fun AddTemplateScreen() {
    var exercises = remember { vm.exercisesState }
    var passName = remember { vm.passTemplateNameState }

    Column {
        Text(text = "Add a template!")
        OutlinedTextField(
            value = passName.value,
            modifier = Modifier,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Info,
                    contentDescription = "passNameIcon"
                )
            },
            onValueChange = { vm.passTemplateNameState.value = it },
            label = { Text(text = "Name") },
            placeholder = { Text(text = "My leg passes... e.g") }
        )

        Row {
            Text(text = "Add Exercise")
            Icon(
                imageVector = Icons.Rounded.Add,
                modifier = Modifier.clickable {
                    exercises.add(Exercise("", ArrayList<ExerciseSet>()))
                },
                contentDescription = "passNameIcon"
            )
        }
        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            items(vm.exercisesState) {
                if (it.name != null) {
                    Log.i("CTDEBUG",it.toString())
                    ExerciseCard(it)
                }
            }
        }
        Row {
            Spacer(modifier = Modifier.weight(1.0f))
            Button(onClick = {
                vm.exercisesState.forEach(action = {
                    Log.i(
                        "CTDEBUG",
                        it.toString()
                    )
                })
            },
                content = { Text(text = "Create Template") })
        }
}
}
    @Composable
    fun ExerciseCard(exercise: Exercise) {
        var exerciseName = remember {
            mutableStateOf(exercise.name)
        }
        var passExerciseSets = remember{ exercise.sets?.toMutableStateList() ?: mutableStateListOf() }

        Column {
            Row {
                TextField(value = exerciseName.value.toString(),
                onValueChange = {
                    exerciseName.value = it
                    exercise.name = it
                })
                Spacer(modifier = Modifier.weight(1.0f))
                Icon(
                    modifier = Modifier.clickable {
                        passExerciseSets.removeLast()
                        exercise.sets?.removeLast() },
                    imageVector = Icons.Rounded.Delete,
                    contentDescription = "AddSetIcon"
                )
                Icon(
                    modifier = Modifier.clickable {
                        passExerciseSets.add(ExerciseSet())
                        exercise.sets?.add(ExerciseSet())
                                                  },
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "AddSetIcon"
                )
            }
            LazyRow {
                items(passExerciseSets.size) { i ->

                    val textRep = remember {
                        mutableStateOf(passExerciseSets[i].rep)
                    }
                    val textEffort = remember {
                        mutableStateOf(passExerciseSets[i].effort)
                    }
                    Column {
                        TextField(
                            modifier = Modifier.width(60.dp),
                            value = textRep.value.toString(),
                            onValueChange = { if (it != "") {
                                textRep.value = it.toInt()
                                exercise.sets?.get(i)?.rep = it.toInt() }
                            })
                        TextField(
                            modifier = Modifier.width(60.dp),
                            value = textEffort.value.toString(),
                            onValueChange = {
                                textEffort.value = it.toInt()
                                exercise.sets?.get(i)?.rep = it.toInt() })
                    }
                }
            }
        }
    }