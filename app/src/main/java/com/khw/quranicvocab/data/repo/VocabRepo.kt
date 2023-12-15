package com.khw.quranicvocab.data.repo

import com.khw.quranicvocab.data.model.Vocab
import kotlinx.coroutines.flow.Flow

interface VocabRepo {
    fun getAll(): Flow<List<Vocab>>
    fun insert(vocab: Vocab)
    fun findVocabById(id: Int): Vocab?
    fun delete(id: Int)
    fun updateStatus(id: Int, status: Boolean)
    fun getLearnedCount(): Int
    fun clear()
}