package com.example.peacemakers.data

import com.example.peacemakers.models.Sermon
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://peacemakers.devstart.co.ke/portal/api/"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface MakersApiService {
    @GET("sermons")
    fun getSermons():Deferred<List<Sermon>>
}

object ApiService{
    val retrofitService : MakersApiService by lazy {
        retrofit.create(MakersApiService::class.java)
    }
}