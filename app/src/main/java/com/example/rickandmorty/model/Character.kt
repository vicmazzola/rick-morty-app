package com.example.rickandmorty.model

data class Character(
    val id: Int = 0,
    val name: String = "",
    var species: String = "",
    var image: String = "",
    val gender: String = ""
    )
