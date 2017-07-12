package library.jdp.jdplib.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import butterknife.ButterKnife
import butterknife.Unbinder
import me.yokeyword.swipebackfragment.SwipeBackFragment

/**
 * Created by jamesdeperio on 7/5/2017.
 */

abstract class SwipeBackBaseFragment : SwipeBackFragment() {
    private var unbinder: Unbinder? = null
    var rootView: View? = null
    protected abstract fun initContentView(): Any
    protected abstract fun initComponents()
    protected abstract fun initServices()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(Integer.parseInt(initContentView().toString()), container, false)
        unbinder = ButterKnife.bind(this, rootView!!)
        initComponents()
        initServices()
        return attachToSwipeBack(rootView)
    }
    override fun onDestroyView() {
        unbinder!!.unbind()
        super.onDestroyView()
    }
}
