package com.khw.quranicvocab.ui.vocabs

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import com.khw.quranicvocab.ui.base.BaseComposeFragment
import com.khw.quranicvocab.ui.vocabs.composable.Review
import com.khw.quranicvocab.ui.vocabs.viewModel.VocabsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VocabsFragment private constructor(): BaseComposeFragment() {
    override val viewModel: VocabsViewModel by viewModels()

    @Composable
    override fun ComposeUI() {
        Review(viewModel)
    }

    companion object {
        private var instance: VocabsFragment? = null

        fun getInstance(): VocabsFragment {
            if (instance == null) {
                instance = VocabsFragment()
            }
            return instance!!
        }
    }
}