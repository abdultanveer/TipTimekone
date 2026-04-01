package com.example.tiptime


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class RoomActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(vm: MainViewModel = viewModel()) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = {
                Log.d("DEMO", "Insert button clicked")
                vm.insertData()

            }
        ) {
            Text("Insert Data")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                vm.retrieveData()

                Log.d("DEMO", "Retrieve button clicked")
            }
        ) {
            Text("Retrieve Data")
        }
    }
}

@Composable
@Preview
fun show(){
    MainScreen()
}