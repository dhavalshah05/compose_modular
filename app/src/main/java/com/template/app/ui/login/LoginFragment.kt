package com.template.app.ui.login

import AuthView
import TabView
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.composetheme.LightDarkView
import com.sample.androidview.ComposeAndroidView
import com.sample.animation.finitemultiplevalues.FiniteMultipleValuesAnimationView
import com.sample.animation.finitesinglevalue.FiniteSingleValueAnimationView
import com.sample.animation.infinite.InfiniteAnimationView
import com.sample.grid.horizontal.HorizontalGridView
import com.sample.grid.vertical.VerticalGridView
import com.sample.pagination.PaginatedListView
import com.sample.ripple.RippleView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = HorizontalGridView(requireContext())
        return view.getRootView()
    }

}