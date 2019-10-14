package com.riso.kotlintest.base

import android.content.Context
import android.content.Intent
import android.widget.Toast

class Utils {

    companion object{

        fun startActivity(context: Context, clazz: Class<*>){

            val intent = Intent(context, clazz)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context?.startActivity(intent)
        }

        fun showToast(context: Context, message: String){

            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

        }
    }
}