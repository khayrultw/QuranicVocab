package com.khw.quranicvocab.ui.learn

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import com.khw.quranicvocab.ui.base.BaseComposeFragment
import com.khw.quranicvocab.ui.learn.composable.Practice
import com.khw.quranicvocab.ui.learn.viewModel.PracticeViewModel

class PracticeFragment: BaseComposeFragment() {
    override val viewModel: PracticeViewModel by viewModels()

    @Composable
    override fun ComposeUI() {
        Practice(viewModel)
    }
}