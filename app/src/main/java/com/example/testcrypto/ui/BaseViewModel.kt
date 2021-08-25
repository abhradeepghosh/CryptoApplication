package com.example.testcrypto.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testcrypto.util.Result

open class BaseViewModel : ViewModel() {

    val _result = MutableLiveData<Result>()
    val result: LiveData<Result> = _result
}