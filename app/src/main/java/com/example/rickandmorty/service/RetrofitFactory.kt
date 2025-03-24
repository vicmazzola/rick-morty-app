package com.example.rickandmorty.service

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val BASE_URL = "https://rickandmortyapi.com/api/"


    //CREATE CONNECTION TO SERVER
    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCharacterService(): CharacterService {
        return retrofitFactory.create(CharacterService::class.java)
    }

}