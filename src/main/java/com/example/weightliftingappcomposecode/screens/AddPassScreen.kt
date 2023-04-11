package com.example.weightliftingappcomposecode.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weightliftingappcomposecode.dataclasses.Exercise
import com.example.weightliftingappcomposecode.models.AddPassViewModel
import com.example.weightliftingappcomposecode.ui.theme.WeightliftingAppComposeCodeTheme

@Preview(showBackground = true)
@Composable
fun ScreenPreview3(){
    WeightliftingAppComposeCodeTheme {
        AddPassScreen()
    }
}
@Composable
fun AddPassScreen() {
    val vm = AddPassViewModel()
    Column {
        OutlinedTextField(
            value = vm.passName.value,
            modifier = Modifier,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Info,
                    contentDescription = "passNameIcon"
                )
            },
            onValueChange = { vm.passName.value = it },
            label = { Text(text = "Name") },
            placeholder = { Text(text = "My leg passes... e.g") }
        )
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = { /*TODO*/ }) {
            Text(text = "Hi")
        }
    }
}