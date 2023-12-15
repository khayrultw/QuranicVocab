package com.khw.quranicvocab.ui.home.viewModel

import com.khw.quranicvocab.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class HomeViewModel: BaseViewModel() {
    val state = MutableStateFlow(0)

}