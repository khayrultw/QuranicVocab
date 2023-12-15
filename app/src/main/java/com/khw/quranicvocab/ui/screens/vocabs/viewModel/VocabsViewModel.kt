package com.khw.quranicvocab.ui.screens.vocabs.viewModel

import com.khw.quranicvocab.data.model.Vocab
import com.khw.quranicvocab.data.repo.VocabRepo
import com.khw.quranicvocab.ui.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class VocabsViewModel @Inject constructor(
    private val repo: VocabRepo
): BaseViewModel() {
    fun getAllVocabs(): Flow<List<Vocab>> {
        return repo.getAll()
    }
}