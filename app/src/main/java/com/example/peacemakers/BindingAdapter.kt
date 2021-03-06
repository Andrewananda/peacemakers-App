package com.example.peacemakers

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter
import com.example.peacemakers.repo.SermonStatus

@BindingAdapter("ApiStatus")
fun displayStatus(statusImageView: ImageView, status: SermonStatus?) {
    when(status) {
        SermonStatus.LOADING->{
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_image)
        }
        SermonStatus.ERROR->{
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        SermonStatus.DONE->{
            statusImageView.visibility = View.GONE
        }
    }
}
