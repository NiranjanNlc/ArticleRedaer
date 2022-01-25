package com.example.articlereader.modal.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id :Int?=null,
    val title :String?=null,
    val url:String?=null ,
    val status :String?=null ,
    val titleImageUrl :String?=null) {
}