package com.reyesmagos

import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.lang.ref.WeakReference

class ActivityToClose : AppCompatActivity(),CloseActionListener {

    /**
     * We create the receiver with a WeakReference to avoid memory leaks
     */
    private val  receiver = CloseActivityReceiver(WeakReference(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_close)

        /**
         * Register the receiver
         */
        registerReceiver(receiver, IntentFilter().apply {
            addAction("MyReceiver")
        })
    }

    /**
     * When listener is called by reciver
     */
    override fun onCloseAction() {
        finish()
    }

    /**
     * Unregister the receiver
     */
    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }

}
