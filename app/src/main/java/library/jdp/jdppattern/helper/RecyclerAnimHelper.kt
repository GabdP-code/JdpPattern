package library.jdp.jdplib.helper

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.animation.OvershootInterpolator
import jp.wasabeef.recyclerview.adapters.*
import library.jdp.jdplib.adapter.PocketAdapter
import library.jdp.jdplib.overrided.RecyclerLinearLayoutManager

/**
 * Created by jamesdeperio on 6/21/2017.
 */

class RecyclerAnimHelper(fragmentActivity: FragmentActivity) {
    private var pocketAdapter: PocketAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var layoutManager: RecyclerView.LayoutManager?
    private var recyclerAnim: RAnim?

    init {
        this.layoutManager = RecyclerLinearLayoutManager(fragmentActivity, LinearLayoutManager.VERTICAL, false)
        this.recyclerAnim = RAnim.SLIDE_BOTTOM
    }

    fun addAnim(anim: RAnim): RecyclerAnimHelper {
        recyclerAnim = anim
        return this
    }
    fun commit(): RecyclerAnimHelper {
        var adapter: AnimationAdapter? = null
        when (recyclerAnim) {
            RAnim.ALPHA_IN -> adapter = AlphaInAnimationAdapter(pocketAdapter)
            RAnim.SCALE_IN -> adapter = ScaleInAnimationAdapter(pocketAdapter)
            RAnim.SLIDE_BOTTOM -> adapter = SlideInBottomAnimationAdapter(pocketAdapter)
            RAnim.SLIDE_LEFT -> adapter = SlideInLeftAnimationAdapter(pocketAdapter)
            RAnim.SLIDE_RIGHT -> adapter = SlideInRightAnimationAdapter(pocketAdapter)
        }
        adapter!!.setDuration(1000)
        adapter.setFirstOnly(false)
        adapter.setInterpolator(OvershootInterpolator())

        recyclerView!!.adapter = adapter
        recyclerView!!.layoutManager = layoutManager
        return this
    }
    fun setRecyclerView(recyclerView: RecyclerView): RecyclerAnimHelper {
        this.recyclerView = recyclerView
        return this
    }
    fun setPocketAdapter(pocketAdapter: PocketAdapter): RecyclerAnimHelper {
        this.pocketAdapter = pocketAdapter
        return this
    }
    fun setLayoutManager(layoutManager: RecyclerView.LayoutManager): RecyclerAnimHelper {
        this.layoutManager = layoutManager
        return this
    }
    fun unRegister(){
        recyclerView=null
        pocketAdapter=null
        layoutManager=null
        recyclerAnim=null
    }
}
