package com.coding.meet.unityadsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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


        val showInterstitialAdsBtn = findViewById<Button>(R.id.showInterstitialAdsBtn)

        val myInterstitialAds = MyInterstitialAds(this)
        // placementId change in  Monetization console
        myInterstitialAds.loadInterstitialAds("video")

        showInterstitialAdsBtn.setOnClickListener {
            // placementId change in  Monetization console
            myInterstitialAds.showInterstitialAds("video") {
                val afterIntent = Intent(this,AfterInterstitialActivity::class.java)
                startActivity(afterIntent)
            }
        }

    }
}