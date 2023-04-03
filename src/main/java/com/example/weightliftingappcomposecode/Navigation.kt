package com.example.weightliftingappcomposecode

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weightliftingappcomposecode.models.DashboardViewModel

@Preview(showBackground = true)
@Composable
fun ScreenPreview(){
    DashboardScreen(DashboardViewModel())
}
    @Composable
    fun DashboardScreen(vm : DashboardViewModel){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Text(text = vm.currentUser.value.name.toString())

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(onClick = { /*TODO*/ },

                    ) {
                    Text(text = "Logout")
                }
                Button(
                    onClick = { /*TODO*/ },
                    shape= RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .height(44.dp)
                        .background(color = MaterialTheme.colorScheme.primary)
                ) {
                    Text(text = "AddPass")
                }
            }
            Spacer(modifier = Modifier.weight(1.0f))
            LazyColumn(modifier =
            Modifier
                .fillMaxWidth()
                .heightIn(0.dp, 232.dp))
            {
                items(vm.passesFinished){ pass ->
                    Text(pass.passName.toString())
                }
                item{
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "+")
                    }
                }
            }
        }
    }