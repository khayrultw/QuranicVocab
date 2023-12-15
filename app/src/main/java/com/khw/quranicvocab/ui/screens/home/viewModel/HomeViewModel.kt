package com.khw.quranicvocab.ui.screens.home.viewModel

import com.khw.quranicvocab.ui.screens.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class HomeViewModel: BaseViewModel() {
    val state = MutableStateFlow(0)

}