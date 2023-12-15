package com.khw.quranicvocab.ui.profile.viewModel

import com.khw.quranicvocab.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ProfileViewModel: BaseViewModel() {
    val state = MutableStateFlow("Hello Compose UI from Review")
}