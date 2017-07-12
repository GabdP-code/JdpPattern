package library.jdp.jdplib.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.widget.Toolbar
import butterknife.ButterKnife
import butterknife.Unbinder

/**
 * Created by jamesdeperio on 7/8/2017.
 */

abstract class SwipeBackActivity : me.yokeyword.swipebackfragment.SwipeBackActivity() {
    private var unbinder: Unbinder? = null
    protected abstract fun initContentView(): Any
    protected abstract fun initSupportingActionBar(): Toolbar
    protected abstract fun initComponents()
    protected abstract fun initServices()
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(Integer.parseInt(initContentView().toString()))
        unbinder = ButterKnife.bind(this)
        setSupportActionBar(initSupportingActionBar())
        initComponents()
        initServices()
    }

    override fun onDestroy() {
        unbinder!!.unbind()
        super.onDestroy()
    }

}


