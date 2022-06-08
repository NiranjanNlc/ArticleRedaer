package com.example.articlereader.modal.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id :Int= (1 .. 1000).random(),
    var title :String,
    var url:String?=null,
    var status :String?=null,
    var titleImageUrl :String?=null)