package com.khw.quranicvocab.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.khw.quranicvocab.data.model.Vocab

@Database(entities = [Vocab::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun vocabDao(): VocabDao

    companion object {
        const val name = "Quranic_Vocab_Database"
    }
}