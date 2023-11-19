package com.coding.meet.unityadsapp

import android.app.Activity
import com.unity3d.ads.*

class MyInterstitialAds(private val activity: Activity) {

    fun loadInterstitialAds(placementId: String) {
        UnityAds.load(placementId, object : IUnityAdsLoadListener {
            override fun onUnityAdsAdLoaded(placementId: String?) {
            }

            override fun onUnityAdsFailedToLoad(
                placementId: String?,
                error: UnityAds.UnityAdsLoadError?,
                message: String?,
            ) {
            }

        })
    }

    fun showInterstitialAds(placementId: String, afterSomeCode: () -> Unit) {
        UnityAds.show(activity, placementId, UnityAdsShowOptions(),
            object : IUnityAdsShowListener {
                override fun onUnityAdsShowFailure(
                    placementIds: String?,
                    error: UnityAds.UnityAdsShowError?,
                    message: String?,
                ) {
                    activity.longToastShow("error = $message")
                    afterSomeCode()
                    loadInterstitialAds(placementId)
                }

                override fun onUnityAdsShowStart(placementId: String?) {
                    activity.longToastShow("onUnityAdsShowStart")

                }

                override fun onUnityAdsShowClick(placementId: String?) {
                    activity.longToastShow("onUnityAdsShowClick")

                }

                override fun onUnityAdsShowComplete(
                    placementIds: String?,
                    state: UnityAds.UnityAdsShowCompletionState?,
                ) {
                    afterSomeCode()
                    loadInterstitialAds(placementId)
                }

            })
    }
}