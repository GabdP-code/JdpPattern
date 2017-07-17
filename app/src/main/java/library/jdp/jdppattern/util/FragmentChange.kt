package library.jdp.jdppattern.util

import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import library.jdp.jdppattern.R
import java.lang.ref.WeakReference

/**
 * Created by jamesdeperio on 7/16/2017.
 */

object FragmentChange {
    fun load(layoutID: Int, fragmentManager: FragmentManager, fragment: Fragment) {
        fragmentManager.beginTransaction()
                .add(layoutID, fragment, fragment.javaClass.simpleName)
                .disallowAddToBackStack()
                .commit()
    }

    fun unLoad(view: WeakReference<View>, fragmentManager: FragmentManager, fragment: Fragment) {
        var handler: Handler? = Handler()
        handler!!.postDelayed({
            CleanView.clearMemory(view)
            fragmentManager.beginTransaction()
                    .remove(fragment)
                    .commit()
            handler = null
        }, 1000)
    }

    fun unLoad(fragmentManager: FragmentManager, fragment: Fragment) {
        var handler: Handler? = Handler()
        handler!!.postDelayed({
            fragmentManager.beginTransaction()
                    .remove(fragment)
                    .commit()
            handler = null
        }, 1000)
        }

    fun add(layoutID: Int, fragmentManager: FragmentManager, fromFragment: Fragment, toFragment: Fragment) {
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.h_fragment_enter, R.anim.h_fragment_exit, R.anim.h_fragment_pop_enter, R.anim.h_fragment_pop_exit)
                .add(layoutID, toFragment, toFragment.javaClass.simpleName)
                .hide(fromFragment)
                .addToBackStack(toFragment.javaClass.simpleName)
                .commit()
    }
}

