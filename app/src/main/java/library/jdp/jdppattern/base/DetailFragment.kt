package library.jdp.jdppattern.base

import android.support.v4.widget.DrawerLayout
import java.lang.ref.WeakReference

abstract class DetailFragment : SwipeBackBaseFragment() {
    protected abstract val initDrawerLayout: WeakReference<DrawerLayout>
    override fun onStart() {
        super.onStart()
        DrawerActivity.setAsDetailFragment()
        initDrawerLayout.get()!!.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

    }
    override fun onDestroyView() {
        super.onDestroyView()
        initDrawerLayout.get()!!.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        DrawerActivity.backToHome()
    }
}
