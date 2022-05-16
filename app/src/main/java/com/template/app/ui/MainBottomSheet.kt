package com.template.app.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.composelibrary.sheets.modalbottomsheet.MainBottomSheetView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MainBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return MainBottomSheetView(requireContext()).getRootView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val parent = view.parent as? View
        parent?.setBackgroundColor(Color.TRANSPARENT)
    }

}