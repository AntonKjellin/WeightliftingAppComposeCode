package com.example.weightliftingappcomposecode.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weightliftingappcomposecode.models.AddTemplateGroupViewModel

@Composable
fun AddTemplateGroup(){
    val vm = AddTemplateGroupViewModel()
    OutlinedTextField(
        value = vm.templateGroupName.value,
        modifier = Modifier,
        leadingIcon = {Icon(imageVector = Icons.Rounded.Add, contentDescription = "passNameIcon")},
        onValueChange = {vm.templateGroupName.value = it}
    )
}