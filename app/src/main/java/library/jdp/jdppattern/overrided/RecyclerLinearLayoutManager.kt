package library.jdp.jdppattern.overrided

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

/**
 * Created by jamesdeperio on 1/18/2017.
 */

class RecyclerLinearLayoutManager(activity: FragmentActivity, horizontal: Int, b: Boolean) : LinearLayoutManager(activity, horizontal, b) {
    private var isScrollEnabled = true

    fun setScrollEnabled(flag: Boolean) {
        this.isScrollEnabled = flag
    }

    override fun canScrollVertically(): Boolean {
        return isScrollEnabled
    }
    override fun canScrollHorizontally(): Boolean {
        return isScrollEnabled
    }
    override fun supportsPredictiveItemAnimations(): Boolean {
        return false
    }
    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State) {
        try {
            super.onLayoutChildren(recycler, state)
        } catch (e: IndexOutOfBoundsException) {
            Log.e("probe", "meet a IOOBE in RecyclerView")
        }

    }
}
