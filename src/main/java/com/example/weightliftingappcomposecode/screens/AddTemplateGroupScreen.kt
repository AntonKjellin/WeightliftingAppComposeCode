package com.example.weightliftingappcomposecode.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weightliftingappcomposecode.models.AddTemplateGroupViewModel
import com.example.weightliftingappcomposecode.ui.theme.WeightliftingAppComposeCodeTheme

@Preview(showBackground = true)
@Composable
fun ScreenPreview2(){
    WeightliftingAppComposeCodeTheme {
        AddTemplateGroup()
    }
}
@Composable
fun AddTemplateGroup(){
    val vm = AddTemplateGroupViewModel()
    Column {
        OutlinedTextField(
            value = vm.templateGroupName.value,
            modifier = Modifier,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Info,
                    contentDescription = "passNameIcon"
                )
            },
            onValueChange = { vm.templateGroupName.value = it },
            label = { Text(text = "Name") },
            placeholder = { Text(text = "My leg passes... e.g") }
        )
        Button(
            modifier = Modifier.align(CenterHorizontally),
            onClick = { /*TODO*/ }) {
            Text(text = "Create Group")
        }
    }
}