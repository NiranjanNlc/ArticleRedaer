package com.example.articlereader.modal.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id :Int?=null,
    var title :String?=null,
    var url:String?=null ,
    var status :String?=null ,
    var titleImageUrl :String?=null)