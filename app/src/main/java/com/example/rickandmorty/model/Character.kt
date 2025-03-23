package com.example.rickandmorty.model

import com.google.gson.annotations.SerializedName

data class Character(
    var id: Int = 0,
    @SerializedName("name") var charName: String = "",
    var species: String = "",
    var image: String = "",
    var gender: String = ""
)
