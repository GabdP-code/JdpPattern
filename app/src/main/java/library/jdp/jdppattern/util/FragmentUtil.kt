package library.jdp.jdplib.util

import android.app.Activity
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import library.jdp.jdplib.R
import library.jdp.jdplib.base.DrawerFragment

/**
 * Created by jamesdeperio on 1/26/2017.
 */

class FragmentUtil(private val activity: Activity) {
    companion object {
        fun loadFragment(layout:  Int , fragmentManager: FragmentManager, toFragment: Fragment) {
            fragmentManager.beginTransaction()
                    .add(layout, toFragment, toFragment.javaClass.simpleName)
                    .disallowAddToBackStack()
                    .commit()
        }
        fun loadFragment(layout: Int, fragmentManager: FragmentManager, toFragment: DrawerFragment) {
            fragmentManager.beginTransaction()
                    .add(layout, toFragment, toFragment.javaClass.simpleName)
                    .disallowAddToBackStack()
                    .commit()
        }
        fun unRegister(view: View, fragmentManager: FragmentManager, fragment: Fragment) {
            var handler: Handler? = Handler()
            handler!!.postDelayed({
                CleanViewUtil.Companion.clearMemory(view)
                fragmentManager.beginTransaction()
                        .remove(fragment)
                        .commit()
                handler=null
            }, 1000)
        }

        fun unRegister(fragmentManager: FragmentManager, fragment: Fragment) {
            var handler: Handler? = Handler()
            handler!!.postDelayed({
            fragmentManager.beginTransaction()
                        .remove(fragment)
                        .commit()
                handler=null
            }, 1000)
        }
        fun onAddFragment(layout: Int, fragmentManager: FragmentManager, fragment: Fragment, toFragment: Fragment) {
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.h_fragment_enter, R.anim.h_fragment_exit, R.anim.h_fragment_pop_enter, R.anim.h_fragment_pop_exit)
                    .add(layout, toFragment, toFragment.javaClass.simpleName)
                    .hide(fragment)
                    .addToBackStack(toFragment.javaClass.simpleName)
                    .commit()
        }
    }
}
