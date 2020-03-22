package com.example.peacemakers.views

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.peacemakers.R
import com.example.peacemakers.databinding.ActivityDetailSermonBinding
import com.example.peacemakers.models.Sermon
import com.example.peacemakers.utils.SERMON_PARCEL
import com.example.peacemakers.viewmodels.DetailSermonViewModel
import com.example.peacemakers.viewmodels.DetailSermonViewModelFactory

class DetailSermon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityDetailSermonBinding = DataBindingUtil.setContentView(this,R.layout.activity_detail_sermon)
        binding.setLifecycleOwner(this)

        val sermon = intent.getParcelableExtra<Parcelable>(SERMON_PARCEL) as Sermon
        val viewModelFactory = DetailSermonViewModelFactory(sermon, Application())
        binding.viewmodel = ViewModelProvider(this,viewModelFactory).get(DetailSermonViewModel::class.java)

    }
}
