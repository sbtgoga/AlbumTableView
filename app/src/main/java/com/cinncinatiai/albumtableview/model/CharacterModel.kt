package com.cinncinatiai.albumtableview.model

data class CharacterModel(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Location,
    val location: Location,
    val image: String,
    val episode: List<String>
)

data class Location(
    val name: String,
    val url: String
)
