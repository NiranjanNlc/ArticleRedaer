package com.example.articlereader.modal.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.articlereader.modal.dao.ArticleDao
import com.example.articlereader.modal.data.Article
import com.example.articlereader.utility.ArticleList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Article::class], version = 2)
abstract class ArticleDataBase : RoomDatabase()
{
        abstract fun reciepedDao(): ArticleDao
        private class ReciepeDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch {
                        //do somrething
                        Log.i("article db", "inserting article databses ")
                        val dao =database.reciepedDao()
                        ArticleList.getArticles().forEach {
                            dao.save(it)
                        }
                    }
                }
            }
        }
        companion object {
            // Singleton prevents multiple instances of database opening at the
            // same time.
            @Volatile
            private var INSTANCE: ArticleDataBase? = null

            fun getDatabase(context: Context, scope: CoroutineScope):ArticleDataBase {
                // if the INSTANCE is not null, then return it,
                // if it is, then create the database]
                println("You have acces over here ")
                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                       ArticleDataBase::class.java,
                        "article_database"
                    ).addCallback(ReciepeDatabaseCallback(scope))
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                    // return instance
                    instance
                }
            }


        }
    }
