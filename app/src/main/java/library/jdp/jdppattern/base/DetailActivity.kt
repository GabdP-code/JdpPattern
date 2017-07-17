package library.jdp.jdppattern.base

import android.support.v4.widget.DrawerLayout
import java.lang.ref.WeakReference

/**
 * Created by jamesdeperio on 7/12/2017.
 */

abstract class DetailActivity : SwipeBackBaseActivity() {

    protected abstract val initDrawerLayout: WeakReference<DrawerLayout>
    override fun onStart() {
        super.onStart()
        DrawerActivity.setAsDetailFragment()
        initDrawerLayout.get()!!.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }
    override fun onDestroy() {
        super.onDestroy()
        initDrawerLayout.get()!!.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        DrawerActivity.backToHome()
    }
}
