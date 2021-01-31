package com.example.navigation_demo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SampleData {

    companion object{
        var defaultAmount = MutableLiveData<Long>(100L)
    }

}