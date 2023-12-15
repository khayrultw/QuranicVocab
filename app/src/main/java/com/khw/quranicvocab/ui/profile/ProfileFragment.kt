package com.khw.quranicvocab.ui.profile

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import com.khw.quranicvocab.ui.base.BaseComposeFragment
import com.khw.quranicvocab.ui.profile.composable.Profile
import com.khw.quranicvocab.ui.profile.viewModel.ProfileViewModel
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