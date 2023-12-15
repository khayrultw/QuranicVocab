package com.khw.quranicvocab.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.khw.quranicvocab.data.model.Vocab
import kotlinx.coroutines.flow.Flow

@Dao
interface VocabDao {
    @Query("SELECT * FROM Vocab")
    fun getAll(): Flow<List<Vocab>>

    @Query("SELECT * FROM Vocab WHERE word < :word AND status = 0 ORDER BY word ASC LIMIT 1")
    fun getNextVocab(word: String): Flow<Vocab?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vocab: Vocab)

    @Query("SELECT * FROM Vocab WHERE id = :id")
    fun findById(id: Int): Vocab?

    @Query("DELETE FROM Vocab WHERE id = :id")
    fun delete(id: Int)

    @Query("UPDATE Vocab SET status = :status WHERE id = :id")
    fun updateStatus(id: Int, status: Boolean)

    @Query("SELECT COUNT(id) FROM Vocab WHERE status = 1")
    fun getLearnedCount(): Int

    @Query("DELETE FROM Vocab")
    fun clear()
}