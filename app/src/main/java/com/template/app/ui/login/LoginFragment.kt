package com.template.app.ui.login

import AuthView
import TabView
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.composetheme.LightDarkView
import com.sample.animation.finitesinglevalue.FiniteSingleValueAnimationView
import com.sample.animation.infinite.InfiniteAnimationView
import com.sample.pagination.PaginatedListView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = FiniteSingleValueAnimationView(requireContext())
        return view.getRootView()
    }

}