package com.example.peacemakers.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.peacemakers.R
import com.example.peacemakers.adapter.SermonAdapter
import com.example.peacemakers.adapter.SermonClickListener
import com.example.peacemakers.databinding.ActivityMainBinding
import com.example.peacemakers.models.Sermon
import com.example.peacemakers.repo.SermonStatus
import com.example.peacemakers.utils.SERMON_PARCEL
import com.example.peacemakers.viewmodels.SermonViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {
private lateinit var viewmodel:SermonViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewmodel = ViewModelProvider(this).get(SermonViewModel::class.java)
        binding.viewmodel = viewmodel
        binding.setLifecycleOwner(this)


        val adapter = SermonAdapter(SermonClickListener {
            val detailsIntent = Intent(this,DetailSermon::class.java).apply {
                putExtra(SERMON_PARCEL,it)
            }
            startActivity(detailsIntent)
        })

        binding.sermonRecyclerview.adapter = adapter
        viewmodel.response.observe(this, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
    }
}
