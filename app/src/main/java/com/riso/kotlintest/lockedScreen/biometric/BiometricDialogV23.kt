package com.riso.kotlintest.lockedScreen.biometric

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.riso.kotlintest.R

class BiometricDialogV23 : BottomSheetDialog, View.OnClickListener {

    private var context: Context? = null

    private var btnCancel: Button? = null
    private var imgLogo: ImageView? = null
    private var itemTitle: TextView? = null
    private var itemDescription:TextView? = null
    private var itemSubtitle:TextView? = null
    private var itemStatus:TextView? = null

    private val biometricCallback: BiometricCallback

    fun BiometricDialogV23(context: Context): ??? {
        super(context, R.style.BottomSheetDialogTheme)
        this.context = context.applicationContext
        setDialogView()
    }

    fun BiometricDialogV23(context: Context, biometricCallback: BiometricCallback): ??? {
        super(context, R.style.BottomSheetDialogTheme)
        this.context = context.applicationContext
        this.biometricCallback = biometricCallback
        setDialogView()
    }

    fun BiometricDialogV23(context: Context, theme: Int): ??? {
        super(context, theme)
    }

    protected fun BiometricDialogV23(
        context: Context,
        cancelable: Boolean,
        cancelListener: DialogInterface.OnCancelListener
    ): ??? {
        super(context, cancelable, cancelListener)
    }

    private fun setDialogView() {
        val bottomSheetView = layoutInflater.inflate(R.layout.view_bottom_sheet, null)
        setContentView(bottomSheetView)

        btnCancel = findViewById(R.id.btn_cancel)
        btnCancel!!.setOnClickListener(this)

        imgLogo = findViewById(R.id.img_logo)
        itemTitle = findViewById(R.id.item_title)
        itemStatus = findViewById<TextView>(R.id.item_status)
        itemSubtitle = findViewById<TextView>(R.id.item_subtitle)
        itemDescription = findViewById<TextView>(R.id.item_description)

        updateLogo()
    }

    fun setTitle(title: String) {
        itemTitle!!.text = title
    }

    fun updateStatus(status: String) {
        itemStatus!!.setText(status)
    }

    fun setSubtitle(subtitle: String) {
        itemSubtitle!!.setText(subtitle)
    }

    fun setDescription(description: String) {
        itemDescription!!.setText(description)
    }

    fun setButtonText(negativeButtonText: String) {
        btnCancel!!.text = negativeButtonText
    }

    private fun updateLogo() {
        try {
            val drawable = getContext().packageManager.getApplicationIcon(context!!.packageName)
            imgLogo!!.setImageDrawable(drawable)

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    override fun onClick(view: View) {
        dismiss()
        biometricCallback.onAuthenticationCancelled()
    }
}