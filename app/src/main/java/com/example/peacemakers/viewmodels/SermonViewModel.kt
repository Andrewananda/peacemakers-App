package com.example.peacemakers.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.peacemakers.models.Sermon
import com.example.peacemakers.repo.SermonRepository
import com.example.peacemakers.repo.SermonStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

class SermonViewModel : ViewModel() {
    //initialize sermonRepository
    private val sermonRepository:SermonRepository = SermonRepository()
    //get Response from api
    val response: LiveData<List<Sermon>>
    //get Status
    val status:LiveData<SermonStatus>
    val job = Job()
    val coroutineScope = CoroutineScope(job +Dispatchers.Main)

    init {
        getSermons()
        response = sermonRepository.sermonresponse
        status = sermonRepository.status
    }

    private fun getSermons() {
        coroutineScope.launch {
            sermonRepository.getSermons()
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}