package com.khw.quranicvocab.data.repo

import com.khw.quranicvocab.data.database.VocabDao
import com.khw.quranicvocab.data.model.Vocab
import kotlinx.coroutines.flow.Flow

class VocabRepoImpl(
    val dao: VocabDao
): VocabRepo {
    override fun getAll(): Flow<List<Vocab>> {
        return dao.getAll()
    }

    override fun insert(vocab: Vocab) {
        dao.insert(vocab)
    }

    override fun findVocabById(id: Int): Vocab? {
        return dao.findById(id)
    }

    override fun delete(id: Int) {
        dao.delete(id)
    }

    override fun updateStatus(id: Int, status: Boolean) {
        dao.updateStatus(id, status)
    }

    override fun getLearnedCount(): Int {
        return dao.getLearnedCount()
    }

    override fun clear() {
        dao.clear()
    }
}