package com.example.peacemakers.models

import android.os.Parcelable
import androidx.annotation.Nullable
import kotlinx.android.parcel.Parcelize
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue

@Parcelize
data class Sermon(
    val id: Int,
    val title:String,
    val day_id: Int,
    val sermon_by: String,
    val description:String,
    val scripture: String,
    val remember_token:String,
    val created_at: String,
    val updated_at: String
):Parcelable