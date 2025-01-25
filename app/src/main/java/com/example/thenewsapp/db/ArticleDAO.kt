package com.example.thenewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.thenewsapp.models.Article

//operacje na bazie danych
@Dao
interface ArticleDAO {
    //dodawanie lub aktualizacja artykulow w bazie danych
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    //pobieranie wszystkich artykulow z bazy danych
    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    //usuwanie artykulow z bazy danych
    @Delete
    suspend fun deleteArticle(article: Article)
}