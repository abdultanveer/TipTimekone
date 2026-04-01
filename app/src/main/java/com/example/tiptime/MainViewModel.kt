package com.example.tiptime

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    //backing property
    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count

    private val _time = MutableStateFlow(10) // start from 10 seconds
    val time: StateFlow<Int> = _time

   // var timeRemaining = 10

    fun startTimer() {
       var countdownTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // This method is called every interval (e.g., every second)
                // Update the UI with the remaining time
                val secondsRemaining = millisUntilFinished / 1000
                _time.value = secondsRemaining.toInt()
                Log.i("MainViewmodel","secs remaining = "+secondsRemaining)
            }

            override fun onFinish() {
                // This method is called when the countdown finishes
                Log.i("MainViewmodel","timer completed")
            }
        }.start()
    }

    fun incrementCount(){
        _count.value++
    }


}