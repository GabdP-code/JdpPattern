package library.jdp.jdplib.util

import android.app.Activity
import android.graphics.Color

import cn.pedant.SweetAlert.SweetAlertDialog

/**
 * Created by jamesdeperio on 6/22/2017.
 */

class SweetAlertUtil {
    companion object{
         fun loader(activity: Activity, title: String, hexColor: String): SweetAlertDialog? {
            val sweetAlertDialog = SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE)
            sweetAlertDialog.progressHelper.barColor = Color.parseColor(hexColor)
            sweetAlertDialog.titleText = title
            sweetAlertDialog.setCancelable(false)
            sweetAlertDialog.show()
            return sweetAlertDialog
        }
         fun basicDialog(activity: Activity, title: String): SweetAlertDialog? {
             val sweetAlertDialog = SweetAlertDialog(activity)
                    .setTitleText(title)
             return sweetAlertDialog
         }
         fun basicDialogWithContent(activity: Activity, title: String, message: String): SweetAlertDialog? {
             val sweetAlertDialog = SweetAlertDialog(activity)
                    .setTitleText(title)
                    .setContentText(message)
             return sweetAlertDialog
         }
         fun error(activity: Activity, title: String, message: String): SweetAlertDialog? {
             val sweetAlertDialog = SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title)
                    .setContentText(message)
             return sweetAlertDialog
         }
         fun success(activity: Activity, title: String, message: String): SweetAlertDialog? {
             val sweetAlertDialog = SweetAlertDialog(activity, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText(title)
                    .setContentText(message)
             return sweetAlertDialog
         }
         fun warning(activity: Activity, title: String, message: String, confirmText: String, cancelText: String): SweetAlertDialog? {
            val sweetAlertDialog = SweetAlertDialog(activity, SweetAlertDialog.WARNING_TYPE)
            sweetAlertDialog.setTitleText(title)
                    .setContentText(message)
                    .setConfirmText(confirmText).cancelText = cancelText
            return sweetAlertDialog
        }

    }

}

