package com.riso.kotlintest.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.riso.kotlintest.R

class RedTextView: AppCompatTextView {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        setInit()
    }

    fun setInit(){
        this.setTextColor(resources.getColor(R.color.red))
    }
}