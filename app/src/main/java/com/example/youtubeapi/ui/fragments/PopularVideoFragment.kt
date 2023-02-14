package com.example.youtubeapi.ui.fragments

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.youtubeapi.base.BaseFragment
import com.example.youtubeapi.ui.adapters.PopularVideoAdapter
import com.excample.youtubeapi.R
import com.excample.youtubeapi.databinding.FragmentPopularVideoBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PopularVideoFragment :
    BaseFragment<FragmentPopularVideoBinding, PopularVideoViewModel>(R.layout.fragment_popular_video) {

    override val viewModel: PopularVideoViewModel by viewModels()
    override val binding by viewBinding(FragmentPopularVideoBinding::bind)
    private val videoAdapter = PopularVideoAdapter()

    override fun setupSubscribes() {
        subscribeToVideoPopular()
    }

    override fun initialize() = with(binding.recView) {
        adapter = videoAdapter
    }

    private fun subscribeToVideoPopular() {
        viewModel.fetchVideosPopular("ru", "mostPopular", "snippet").observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                videoAdapter.submitData(it)
            }
        }
    }
}