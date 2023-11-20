package com.coding.meet.unityadsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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
//            "Banner_Android",
//            UnityBannerSize(320,50)
//        )

        // iabStandard Banner Size
//        showBannerAds(
//            this,
//            findViewById(R.id.adBannerCon),
//            "Banner_Android",
//         UnityBannerSize.iabStandard
//        )

        //leaderboard Banner Size
//        showBannerAds(
//            this,
//            findViewById(R.id.adBannerCon),
//            "Banner_Android",
//         UnityBannerSize.leaderboard
//        )

        //standard Banner Size
        showBannerAds(
            this,
            findViewById(R.id.adBannerCon),
            "Banner_Android",
            UnityBannerSize.standard
        )


        val showInterstitialAdsBtn = findViewById<Button>(R.id.showInterstitialAdsBtn)

        val myInterstitialAds = MyInterstitialAds(this)
        // placementId change in  Monetization console
        myInterstitialAds.loadInterstitialAds("Interstitial_Android")

        showInterstitialAdsBtn.setOnClickListener {
            // placementId change in  Monetization console
            myInterstitialAds.showInterstitialAds("Interstitial_Android") {
                val afterIntent = Intent(this,AfterInterstitialActivity::class.java)
                startActivity(afterIntent)
            }
        }

        val sharedPreferenceManger = SharedPreferenceManger(this)
        getRewardedCoin(sharedPreferenceManger.totalRewardedCoin)
        val showRewardedAdsBtn = findViewById<Button>(R.id.showRewardedAdsBtn)
        val myRewardedAds = MyRewardedAds(this)
        // placementId change in  Monetization console
        myRewardedAds.loadRewardedAds("Rewarded_Android")

        showRewardedAdsBtn.setOnClickListener {
            // placementId change in  Monetization console
            myRewardedAds.showRewardedAds("Rewarded_Android"){
                val rewardedCoin = 10 // Here Your Rewarded Coin Add
                sharedPreferenceManger.totalRewardedCoin += rewardedCoin
                getRewardedCoin(sharedPreferenceManger.totalRewardedCoin)
            }
        }

    }

    private fun getRewardedCoin(totalRewardedCoin: Int) {
        val rewardedCoinTxt = findViewById<TextView>(R.id.rewardedCoinTxt)
        rewardedCoinTxt.text = "Total Rewarded Coins: $totalRewardedCoin Coins"
    }
}