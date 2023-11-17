package com.coding.meet.unityadsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.unity3d.services.banners.UnityBannerSize

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // placementId change in  Monetization console
        // Custom Banner Size
//        showBannerAds(
//            this,
//            findViewById(R.id.adBannerCon),
//            "bannerads",
//            UnityBannerSize(320,50)
//        )

        // iabStandard Banner Size
//        showBannerAds(
//            this,
//            findViewById(R.id.adBannerCon),
//            "bannerads",
//         UnityBannerSize.iabStandard
//        )

        //leaderboard Banner Size
//        showBannerAds(
//            this,
//            findViewById(R.id.adBannerCon),
//            "bannerads",
//         UnityBannerSize.leaderboard
//        )

        //standard Banner Size
        showBannerAds(
            this,
            findViewById(R.id.adBannerCon),
            "bannerads",
            UnityBannerSize.standard
        )
    }
}