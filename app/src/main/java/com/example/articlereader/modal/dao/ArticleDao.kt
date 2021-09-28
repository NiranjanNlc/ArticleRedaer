package com.example.articlereader.modal.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.example.articlereader.modal.data.Article


@Dao
interface ArticleDao
{
    
    interface ReciepeDao {
        @Insert(onConflict = REPLACE)
        fun save(reciepe:Article)

        @Update
        fun update(reciepe: Article)

        @Query("SELECT * FROM  article")
        fun getAlphabetizedWords(): LiveData<List<Article>>

    }
}