package com.example.unilocation.universalGeofence.hms

import android.app.PendingIntent
import android.content.Context
import androidx.annotation.RequiresPermission
import com.example.unilocation.universalGeofence.GeofenceClient
import com.example.unilocation.universalGeofence.GeofenceRequest
import com.example.unilocation.universalLocation.TaskWrapper
import com.example.unilocation.universalLocation.hms.TaskWrapperHms
import com.huawei.hms.location.LocationServices

class GeofenceClientHms (private val context: Context): GeofenceClient {

    private val geofencingClient = LocationServices.getGeofenceService(context)

    private val geofenceRequestHmsMapper = GeofenceRequestHmsMapper()
    @RequiresPermission(anyOf = ["android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"])
    override fun addGeofences(
        request: GeofenceRequest,
        pendingIntent: PendingIntent
    ): TaskWrapper<Any> {
        return TaskWrapperHms(
            geofencingClient.createGeofenceList(
                geofenceRequestHmsMapper.createGeofenceRequestGms(request),
                pendingIntent
            ).continueWith {  }
        )
    }

    override fun removeGeofences(requestIds: List<String>): TaskWrapper<Any> {
        return TaskWrapperHms(
            geofencingClient.deleteGeofenceList(requestIds).continueWith {  }
        )
    }

    override fun removeGeofences(pendingIntent: PendingIntent): TaskWrapper<Any> {
        return TaskWrapperHms(
            geofencingClient.deleteGeofenceList(pendingIntent).continueWith {  }
        )
    }
}