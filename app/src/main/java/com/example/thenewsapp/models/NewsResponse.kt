package com.example.thenewsapp.models

//Klasa NewsResponse reprezentuje odpowiedz ktora otrzymujemy z API z wiadomościami
data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)