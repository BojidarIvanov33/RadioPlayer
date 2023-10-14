package com.example.radioplayer

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        var isBluetoothUnPair = intent?.getBooleanExtra("STATE", true) ?: return
       if(isBluetoothUnPair) {
           label?.text="Bluetooth disconnect"
           mediaPlayer?.stop()
       }

    }

}