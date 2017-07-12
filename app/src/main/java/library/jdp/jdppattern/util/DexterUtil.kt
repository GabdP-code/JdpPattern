package library.jdp.jdplib.util

import android.app.Activity
import android.util.Log
import android.view.View
import android.view.ViewGroup

import com.karumi.dexter.Dexter
import com.karumi.dexter.listener.DexterError
import com.karumi.dexter.listener.PermissionRequestErrorListener
import com.karumi.dexter.listener.multi.CompositeMultiplePermissionsListener
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

import library.jdp.jdplib.listener.MultiplePermissionListener


/**
 * Created by jamesdeperio on 6/22/2017.
 */

class DexterUtil {
    companion object{
        fun showPermissionDialog(activity: Activity, permission: Collection<String>, listener: MultiplePermissionListener) {
            val allPermissionsListener = CompositeMultiplePermissionsListener(listener)
            Dexter.withActivity(activity)
                    .withPermissions(permission)
                    .withListener(allPermissionsListener)
                    .withErrorListener { error -> Log.e("Permission Error:", error.toString()) }
                    .check()

        }
    }
}
