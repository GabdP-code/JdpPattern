package library.jdp.jdppattern.base

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.widget.Toolbar
import butterknife.ButterKnife
import butterknife.Unbinder
import me.yokeyword.swipebackfragment.SwipeBackActivity

/**
 * Created by jamesdeperio on 7/8/2017.
 */

abstract class SwipeBackBaseActivity : SwipeBackActivity() {
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
        super.onDestroy()
        unbinder!!.unbind()
    }
    fun showDialog(intent: Intent){
        startActivity(intent)
    }
}


