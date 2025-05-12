package com.cinncinatiai.albumtableview.model


data class CharacterResponse(
    val info: Info,
    val results: List<CharacterModel>
)

data class Info(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String
)
