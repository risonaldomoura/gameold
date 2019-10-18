package com.riso.kotlintest.lockedScreen

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.fingerprint.FingerprintManager
import android.os.CancellationSignal
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.riso.kotlintest.base.Utils
import com.riso.kotlintest.homeScreen.HomeView

class FingerprintHandler (private val appContext: Context) : FingerprintManager.AuthenticationCallback() {

    private var cancellationSignal: CancellationSignal? = null

    fun startAuth(manager: FingerprintManager,
                  cryptoObject: FingerprintManager.CryptoObject) {

        cancellationSignal = CancellationSignal()

        if (ActivityCompat.checkSelfPermission(appContext,
                Manifest.permission.USE_FINGERPRINT) !=
            PackageManager.PERMISSION_GRANTED) {
            return
        }

        try {
            manager.authenticate(cryptoObject, cancellationSignal, 0, this, null)
        }catch (sce: SecurityException) {
        }

    }﻿


    /*override fun onAuthenticationError(errMsgId: Int,
                                       errString: CharSequence) {
        Toast.makeText(appContext,
            "Authentication error\n" + errString,
            Toast.LENGTH_LONG).show()
    }

    override fun onAuthenticationHelp(helpMsgId: Int,
                                      helpString: CharSequence) {
        Toast.makeText(appContext,
            "Authentication help\n" + helpString,
            Toast.LENGTH_LONG).show()
    }

    override fun onAuthenticationFailed() {
        Toast.makeText(appContext,
            "Authentication failed.",
            Toast.LENGTH_LONG).show()
    }

    override fun onAuthenticationSucceeded(
        result: FingerprintManager.AuthenticationResult) {

        Toast.makeText(appContext,
            "Authentication succeeded.",
            Toast.LENGTH_LONG).show()

        Utils.startActivity(appContext, HomeView::class.java)
    }﻿*/
}﻿
