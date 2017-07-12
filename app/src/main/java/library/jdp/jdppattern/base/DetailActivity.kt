package library.jdp.jdppattern.base

import android.support.v4.widget.DrawerLayout
import library.jdp.jdplib.base.DrawerActivity
import library.jdp.jdplib.base.SwipeBackBaseActivity

/**
 * Created by jamesdeperio on 7/12/2017.
 */

abstract class DetailActivity : SwipeBackBaseActivity() {
    protected abstract val initDrawerLayout: DrawerLayout
    override fun onStart() {
        super.onStart()
        DrawerActivity.setAsDetailFragment()
        initDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }
    override fun onDestroy() {
        super.onDestroy()
        initDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        DrawerActivity.backToHome()
    }
}
