package library.jdp.jdplib.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import butterknife.ButterKnife
import butterknife.Unbinder

/**
 * Created by jamesdeperio on 6/25/2017.
 */

abstract class BaseActivity : AppCompatActivity() {
    private var unbinder: Unbinder? = null
    protected abstract fun initContentView(): Any
    protected abstract fun initSupportingActionBar(): Toolbar?
    protected abstract fun initComponents()
    protected abstract fun initServices()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Integer.parseInt(initContentView().toString()))
        unbinder = ButterKnife.bind(this)
        if(initSupportingActionBar()!=null)
        setSupportActionBar(initSupportingActionBar())
        initComponents()
        initServices()
    }
    override fun onDestroy() {
        unbinder!!.unbind()
        unbinder=null
        super.onDestroy()
    }

}
