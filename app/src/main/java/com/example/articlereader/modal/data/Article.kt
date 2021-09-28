package com.example.articlereader.modal.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val title :String,
    val url:String ,
    val status :String ,
    val titleImageUrl :String) {
}