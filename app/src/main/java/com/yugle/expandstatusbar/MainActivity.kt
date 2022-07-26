package com.yugle.expandstatusbar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        @SuppressLint("WrongConstant")
        val service = getSystemService("statusbar")
        val statusBarManager = Class.forName("android.app.StatusBarManager")

        val itExpandSetting =
            intent?.action == getString(R.string.shortcuts_expand_setting_bar_action)
        val methodName =
            if (itExpandSetting) {
                "expandSettingsPanel"
            } else {
                "expandNotificationsPanel"
            }
        val collapse =
            statusBarManager.getMethod(methodName)
        collapse.isAccessible = true
        collapse.invoke(service)

        finish()
    }
}