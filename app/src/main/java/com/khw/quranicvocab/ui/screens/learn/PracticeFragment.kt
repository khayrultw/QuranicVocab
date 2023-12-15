package com.khw.quranicvocab.ui.screens.learn

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import com.khw.quranicvocab.ui.screens.base.BaseComposeFragment
import com.khw.quranicvocab.ui.screens.learn.composable.Practice
import com.khw.quranicvocab.ui.screens.learn.viewModel.PracticeViewModel

class PracticeFragment: BaseComposeFragment() {
    override val viewModel: PracticeViewModel by viewModels()

    @Composable
    override fun ComposeUI() {
        Practice(viewModel)
    }
}