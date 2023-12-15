package com.khw.quranicvocab.ui.screens.profile

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import com.khw.quranicvocab.ui.screens.base.BaseComposeFragment
import com.khw.quranicvocab.ui.screens.profile.composable.Profile
import com.khw.quranicvocab.ui.screens.profile.viewModel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment private constructor(): BaseComposeFragment() {
    override val viewModel: ProfileViewModel by viewModels()

    @Composable
    override fun ComposeUI() {
        Profile(viewModel)
    }

    companion object {
        private var instance: ProfileFragment? = null

        fun getInstance(): ProfileFragment {
            if (instance == null) {
                instance = ProfileFragment()
            }
            return instance!!
        }
    }
}