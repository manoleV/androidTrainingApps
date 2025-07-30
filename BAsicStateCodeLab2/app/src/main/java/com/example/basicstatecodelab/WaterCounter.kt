package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatefulCounter(modifier: Modifier = Modifier){
    var count by rememberSaveable { mutableIntStateOf(0) }
    StatelessCounter(count, {count ++ }, modifier)
}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier){
    Column(modifier = Modifier.padding(16.dp)) {
        if (count > 0) {
            Text("u drank $count glasses. GOOD JOB")
        }
        Button(
            onClick = onIncrement,
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("sip boy")
        }
    }
}



/*
@Composable
fun WaterCounter(modifier: Modifier=Modifier){

    Column(
        modifier = modifier
            .padding(all = 16.dp)
            .padding(top = 30.dp)
    ) {
        var count by rememberSaveable {mutableStateOf(0)}

        if(count > 0){
            Text(text = "You have consumed $count glasses.")

            var showTask by rememberSaveable { mutableStateOf(true) }
            if(showTask){
                WellnessTaskItem(taskName = "got 15 minuts for a walk big dag?",
                    onClose = {showTask = false})
            }
        }


        Row(modifier = Modifier.padding(all = 16.dp)) {
            Button(
                onClick = { count++ },
                enabled = count <10
            ) { Text("drank another one") }


            Button(
                onClick = {count = 0}
            ){
                Text("eliberate water")
            }
        }


    }
}*/
