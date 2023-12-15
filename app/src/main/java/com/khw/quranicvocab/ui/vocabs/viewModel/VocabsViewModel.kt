package com.khw.quranicvocab.ui.vocabs.viewModel

import androidx.lifecycle.viewModelScope
import com.khw.quranicvocab.data.model.Vocab
import com.khw.quranicvocab.data.repo.VocabRepo
import com.khw.quranicvocab.ui.base.BaseViewModel
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VocabsViewModel @Inject constructor(
    private val repo: VocabRepo
): BaseViewModel() {
    fun getAllVocabs(): Flow<List<Vocab>> {
        return repo.getAll()
    }
}