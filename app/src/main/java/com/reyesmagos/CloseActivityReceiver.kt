package com.reyesmagos

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import java.lang.ref.WeakReference

interface CloseActionListener {

    fun onCloseAction()
}

class CloseActivityReceiver(private val closeActionListener: WeakReference<CloseActionListener>) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        closeActionListener.get()?.onCloseAction()
    }
}