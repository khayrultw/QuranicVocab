package com.khw.quranicvocab.ui.home

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.khw.quranicvocab.R
import com.khw.quranicvocab.core.utils.Utils
import com.khw.quranicvocab.ui.base.BaseComposeFragment
import com.khw.quranicvocab.ui.home.composable.Home
import com.khw.quranicvocab.ui.home.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.tasks.await

@AndroidEntryPoint
class HomeFragment: BaseComposeFragment() {
    override val viewModel: HomeViewModel by viewModels()
    private lateinit var mGoogleSignInClient: GoogleSignInClient

    private val googleSignInLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        Log.d("debugging","${result.resultCode}")
        if (result.resultCode == Activity.RESULT_OK) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            try {
                val account = task.result!!
                Log.d("debugging","${account.displayName}")
            } catch (e: Exception) {
                Log.w("debugging", "Google sign in failed", e)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(Utils.getAuthKey())
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
    }

    @Composable
    override fun ComposeUI() {
        Home(navController, viewModel) {
            googleSignInLauncher.launch(mGoogleSignInClient.signInIntent)
        }
    }

    companion object {
        private var instance: HomeFragment? = null

        fun getInstance(): HomeFragment {
            if (instance == null) {
                instance = HomeFragment()
            }
            return instance!!
        }
    }
}