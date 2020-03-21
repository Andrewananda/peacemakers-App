package com.example.peacemakers.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.peacemakers.data.ApiService
import com.example.peacemakers.models.Sermon
import timber.log.Timber
import java.util.*
import kotlin.collections.ArrayList

enum class SermonStatus {LOADING, ERROR, DONE}

class SermonRepository {
    //set data status
    val _status = MutableLiveData<SermonStatus>()
    val status:LiveData<SermonStatus>
    get() = _status
    //Load data from repository
    private val apiService = ApiService
    val _sermonresponse = MutableLiveData<List<Sermon>>()
    val sermonresponse:LiveData<List<Sermon>>
    get() = _sermonresponse


    suspend fun getSermons() {
        var getDeferred = apiService.retrofitService.getSermons()
        try {
            //Animate loading while data is still loading
            _status.value = SermonStatus.LOADING
            Timber.i("LOADING STATUS")
            var result = getDeferred.await()
            //Display data
            _status.value = SermonStatus.DONE
            Timber.i("DONE STATUS")
            _sermonresponse.value = result

        }catch (t:Throwable){
            //Display error when data is not available or there is an error
            _status.value = SermonStatus.ERROR
            Timber.i("Error Occured")
            _sermonresponse.value = ArrayList()
        }
    }



}