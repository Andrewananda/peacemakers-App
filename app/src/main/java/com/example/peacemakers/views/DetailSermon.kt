package com.example.peacemakers.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.peacemakers.R
import com.example.peacemakers.databinding.ActivityDetailSermonBinding
import com.example.peacemakers.utils.SERMON_PARCEL
import com.example.peacemakers.viewmodels.DetailSermonViewModel

class DetailSermon : AppCompatActivity() {
private lateinit var  viewModel:DetailSermonViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityDetailSermonBinding = DataBindingUtil.setContentView(this,R.layout.activity_detail_sermon)
        viewModel = ViewModelProvider(this).get(DetailSermonViewModel::class.java)
        binding.viewmodel = viewModel
        binding.setLifecycleOwner(this)

    }
}
