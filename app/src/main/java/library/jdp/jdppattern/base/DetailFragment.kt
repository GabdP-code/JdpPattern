package library.jdp.jdplib.base

import android.support.v4.widget.DrawerLayout

abstract class DetailFragment : SwipeBackBaseFragment() {
    protected abstract val initDrawerLayout: DrawerLayout
    override fun onStart() {
        super.onStart()
        DrawerActivity.setAsDetailFragment()
        initDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

    }
    override fun onDestroyView() {
        super.onDestroyView()
        initDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        DrawerActivity.backToHome()
    }
}
