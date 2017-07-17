package library.jdp.jdppattern.util

import android.app.Activity
import android.util.Log
import com.karumi.dexter.Dexter
import com.karumi.dexter.listener.multi.CompositeMultiplePermissionsListener
import library.jdp.jdppattern.listener.MultiplePermissionListener
import java.lang.ref.WeakReference

/**
 * Created by jamesdeperio on 7/15/2017.
 */

object UserPermission {
    fun showPermissionDialog(activity: WeakReference<Activity>, permission: WeakReference<List<String>>, listener: MultiplePermissionListener) {
        val allPermissionsListener = CompositeMultiplePermissionsListener(listener)
        Dexter.withActivity(activity.get())
                .withPermissions(permission.get())
                .withListener(allPermissionsListener)
                .withErrorListener { error -> Log.e("Permission Error:", error.toString()) }
                .check()
    }
}
