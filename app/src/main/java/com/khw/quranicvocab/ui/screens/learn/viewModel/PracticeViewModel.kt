package com.khw.quranicvocab.ui.screens.learn.viewModel

import com.khw.quranicvocab.ui.screens.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class PracticeViewModel: BaseViewModel() {
    val state: MutableStateFlow<PracticeUiModel> = MutableStateFlow(PracticeUiModel())
}