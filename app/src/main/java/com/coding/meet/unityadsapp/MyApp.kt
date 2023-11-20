package com.coding.meet.unityadsapp

import android.app.Application
import com.unity3d.ads.*

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        // gameId change in  Monetization console
        // testMode if app release change to false
        UnityAds.initialize(this,"5204341",true,
            object : IUnityAdsInitializationListener{
                override fun onInitializationComplete() {}

                override fun onInitializationFailed(
                    error: UnityAds.UnityAdsInitializationError?,
                    message: String?,
                ) {
                }

            })

    }
}