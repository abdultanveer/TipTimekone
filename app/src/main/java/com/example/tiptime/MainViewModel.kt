package com.example.tiptime

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel: ViewModel() {
    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count


    fun incrementCount(){
        _count.value++
    }
}