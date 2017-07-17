package library.jdp.jdppattern.util

import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView

import java.lang.ref.WeakReference

/**
 * Created by jamesdeperio on 7/15/2017.
 */

object CleanView {
    fun clearMemory(view: WeakReference<View>?) {
        if (view?.get()?.background != null)
            view.get()?.background?.callback = null
        if (view?.get() is ViewGroup && view.get() !is AdapterView<*>) {
            for (i in 0..(view.get() as ViewGroup).childCount - 1)
                clearMemory(WeakReference((view.get() as ViewGroup).getChildAt(i)))
            (view.get() as ViewGroup).removeAllViews()
        }
    }
}
