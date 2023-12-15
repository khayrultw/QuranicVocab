package com.khw.quranicvocab.ui.screens.base

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

abstract class BaseFragment: Fragment() {
    protected lateinit var navController: NavController
    protected abstract val viewModel: BaseViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = NavHostFragment.findNavController(this)

        lifecycleScope.launch {
            viewModel.error.collect {
                showSnackbar(view, it, true)
            }
        }

        lifecycleScope.launch {
            viewModel.success.collect {
                showSnackbar(view, it)
            }
        }
    }

    fun showSnackbar(view: View, msg: String, isError: Boolean = false) {
        val snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG)
        if(isError) {
            snackbar.setBackgroundTint(Color.RED)
        }
        snackbar.show()
    }
}