package com.khw.quranicvocab.ui.screens.profile.viewModel

import com.khw.quranicvocab.ui.screens.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ProfileViewModel: BaseViewModel() {
    val state = MutableStateFlow("Hello Compose UI from Review")
}