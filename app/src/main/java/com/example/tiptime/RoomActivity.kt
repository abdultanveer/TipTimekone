package com.example.tiptime


import RoomViewModel
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tiptime.data.AppDatabase
import com.example.tiptime.data.MainViewModelFactory

class RoomActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(): Unit {
    val context = LocalContext.current
    val db: AppDatabase = AppDatabase.getDatabase(context)
  //  val app = context.applicationContext as MyApp

    val vm: RoomViewModel = viewModel(
        factory = MainViewModelFactory(db.userDao())
    )

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