package com.example.peacemakers.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.peacemakers.data.ApiService
import com.example.peacemakers.models.Sermon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TestViewModel : ViewModel() {
    val _response = MutableLiveData<List<Sermon>>()
    val response : LiveData<List<Sermon>>
    get() = _response

    val job = Job()
    val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    init {
        getSermons()
    }

    private fun getSermons() {
        val getDeferred = ApiService.retrofitService.getSermons()
        coroutineScope.launch {
            var results = getDeferred.await()
            try {
                _response.value = results
            }catch (t:Throwable) {
                _response.value = ArrayList()
            }
        }

    }

}