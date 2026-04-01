package com.example.tiptime.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RoomViewModel(application: Application) : AndroidViewModel(application) {

    private val userDao = AppDatabase
        .getDatabase(application)
        .userDao()

    fun insertData() {
        viewModelScope.launch {
            val user = User(name = "User ${System.currentTimeMillis()}")
            userDao.insert(user)

            Log.d("DEMO", "Inserted: ${user.name}")
        }
    }

    fun retrieveData() {
        viewModelScope.launch {
            val users = userDao.getAllUsers()

            users.forEach {
                Log.d("DEMO", "User: id=${it.id}, name=${it.name}")
            }

            if (users.isEmpty()) {
                Log.d("DEMO", "No data found")
            }
        }
    }
}