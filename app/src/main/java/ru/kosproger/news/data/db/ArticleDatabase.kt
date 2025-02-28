package ru.kosproger.news.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.kosproger.news.models.Article

@Database(entities = [Article::class], version = 1, exportSchema = true)
abstract class ArticleDatabase: RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao

}