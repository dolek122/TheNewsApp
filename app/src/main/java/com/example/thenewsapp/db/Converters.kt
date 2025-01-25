package com.example.thenewsapp.db

import androidx.room.TypeConverter
import com.example.thenewsapp.models.Source
//Konwertery dla Room
class Converters {

    //Konwertuje obiekt typu Source na String
    @TypeConverter
    fun fromSource(source: Source): String{
        return source.name
    }

    //Konwertuje String z powrotem na obiekt typu Source
    @TypeConverter
    fun toSource(name: String): Source{
        return Source(name, name)
    }
}