package com.coding.meet.unityadsapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class SharedPreferenceManger(context: Context) {
    private val preference = context.getSharedPreferences(
        context.packageName,
        AppCompatActivity.MODE_PRIVATE
    )
    private val editor = preference.edit()


    private val keyTotalRewardedCoin = "totalRewardedCoin"

    var totalRewardedCoin
        get() = preference.getInt(keyTotalRewardedCoin, 0)
        set(value) {
            editor.putInt(keyTotalRewardedCoin, value)
            editor.commit()
        }

}