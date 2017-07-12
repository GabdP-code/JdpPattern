package library.jdp.jdplib.util

import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView

/**
 * Created by jamesdeperio on 1/31/2017.
 */

class CleanViewUtil {
    companion object {
        fun clearMemory(view: View) {
            Runtime.getRuntime().gc()
            System.gc()
            if (view.background != null)
                view.background.callback = null
            if (view is ViewGroup && view !is AdapterView<*>) {
                for (i in 0..view.childCount - 1)
                    clearMemory(view.getChildAt(i))
                view.removeAllViews()
            }
        }
    }

}
