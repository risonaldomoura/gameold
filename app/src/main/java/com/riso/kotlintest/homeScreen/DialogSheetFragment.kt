package com.riso.kotlintest.homeScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.riso.kotlintest.R

class DialogSheetFragment : BottomSheetDialogFragment() {

    var bottomSheetPeekHeight: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bottomSheetPeekHeight = getResources()
            .getDimensionPixelSize(R.dimen.bottom_sheet_default_peek_height);

        return inflater.inflate(R.layout.dialog_finger, container, false)
    }

    companion object{
        fun newInstance() = DialogSheetFragment()
    }

    override fun onResume() {
        super.onResume()

        setUpBottomSheet()
    }

    private fun setUpBottomSheet() {


        //bottomSheetBehavior.setPeekHeight(bottomSheetPeekHeight);

    }
}