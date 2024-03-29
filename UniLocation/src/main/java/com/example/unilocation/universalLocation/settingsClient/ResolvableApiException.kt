package com.example.unilocation.universalLocation.settingsClient

import android.app.Activity
import android.app.PendingIntent

interface ResolvableApiException {

    fun getResolution(): PendingIntent

    fun startResolutionForResult(activity: Activity, requestCode: Int)

}