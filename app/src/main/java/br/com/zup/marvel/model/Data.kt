package br.com.zup.marvel.model

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val characterResults: List<CharacterResult>,
    val total: Int
)