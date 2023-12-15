package com.khw.quranicvocab.ui.screens.tabContainer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.khw.quranicvocab.R
import com.khw.quranicvocab.databinding.FragmentHomeBinding
import com.khw.quranicvocab.ui.screens.home.HomeFragment
import com.khw.quranicvocab.ui.screens.profile.ProfileFragment
import com.khw.quranicvocab.ui.screens.vocabs.VocabsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TabContainerFragment: Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabs = listOf(
            HomeFragment.getInstance(),
            VocabsFragment.getInstance(),
            ProfileFragment.getInstance()
        )
        binding.vpHome.adapter = PagerAdapter(tabs)
        TabLayoutMediator(binding.tlTabs, binding.vpHome) { tab, position ->
            when(position) {
                0 -> {
                    tab.setIcon(R.drawable.ic_home)
                }
                1 -> {
                    tab.setIcon(R.drawable.ic_list)
                }
                else -> {
                    tab.setIcon(R.drawable.ic_profile)
                }
            }
        }.attach()
    }

    inner class PagerAdapter(
        private val tabs: List<Fragment>
    ): FragmentStateAdapter(this@TabContainerFragment) {
        override fun getItemCount() = tabs.size

        override fun createFragment(position: Int): Fragment {
            return tabs[position]
        }
    }
}