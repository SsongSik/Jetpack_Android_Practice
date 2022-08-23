package com.example.a4_coroutineviewmodelscope

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SecondViewModel : ViewModel() {

    fun a(){
        CoroutineScope(Dispatchers.IO).launch{
            for(i in 0..10){
                delay(1000)
                Log.d("SecondViewModel A : ", i.toString())
            }
        }
    }

    //불필요한 연산을 없앨 수 있음
    fun b(){
        viewModelScope.launch {
            for(i in 0..10){
                delay(1000)
                Log.d("SecondViewModel B : ", i.toString())
            }
        }
    }
}