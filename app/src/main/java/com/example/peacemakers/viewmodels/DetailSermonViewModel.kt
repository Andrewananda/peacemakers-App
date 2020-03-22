package com.example.peacemakers.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.peacemakers.models.Sermon

class DetailSermonViewModel(selectedSermonProperty:Sermon,app:Application):AndroidViewModel(app) {
    private val _selectedSermon = MutableLiveData<Sermon>()
    val selectedSermon:LiveData<Sermon>
    get() = _selectedSermon

    init {
        _selectedSermon.value = selectedSermonProperty
    }
}