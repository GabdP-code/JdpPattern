package library.jdp.jdppattern.base

import android.os.Bundle
import android.util.DisplayMetrics
import butterknife.ButterKnife
import butterknife.Unbinder
import me.yokeyword.swipebackfragment.SwipeBackActivity

/**
 * Created by jamesdeperio on 7/16/2017.
 */

abstract class BaseDialog : SwipeBackActivity(){
    private var unbinder: Unbinder? = null
    protected abstract fun initContentView(): Any
    protected abstract fun  initDialogHeightPercent(): Float
    protected abstract fun initDialogWidthPercent(): Float
    protected abstract fun initComponents()
    protected abstract fun initEvents()
    abstract fun allowOnBackedPressed(): Boolean
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Integer.parseInt(initContentView().toString()))
        unbinder = ButterKnife.bind(this)
        val dm= DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val width : Int = dm.widthPixels
        val height : Int = dm.heightPixels
        window.setLayout((width*initDialogWidthPercent()).toInt(), (height*initDialogHeightPercent()).toInt())
        initComponents()
        initEvents()
    }

    override fun onDestroy() {
        unbinder!!.unbind()
        unbinder=null
        super.onDestroy()
    }
    override fun onBackPressed() {
        if(allowOnBackedPressed())
        super.onBackPressed()
    }


}
