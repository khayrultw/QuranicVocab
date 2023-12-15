package com.khw.quranicvocab.ui.learn.viewModel

import com.khw.quranicvocab.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class PracticeViewModel: BaseViewModel() {
    val state: MutableStateFlow<PracticeUiModel> = MutableStateFlow(PracticeUiModel())
}