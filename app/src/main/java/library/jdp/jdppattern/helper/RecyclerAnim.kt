package library.jdp.jdppattern.helper

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.animation.OvershootInterpolator
import jp.wasabeef.recyclerview.adapters.*
import library.jdp.jdppattern.adapter.PocketAdapter
import library.jdp.jdppattern.overrided.RecyclerLinearLayoutManager
import java.lang.ref.WeakReference

/**
 * Created by jamesdeperio on 7/16/2017.
 */

class RecyclerAnim(private val fragmentActivity: WeakReference<FragmentActivity>) {
    companion object {
        val SCALE_IN: Byte = 0
        val ALPHA_IN: Byte = 1
        val SLIDE_RIGHT: Byte = 2
        val SLIDE_LEFT: Byte = 3
        val SLIDE_BOTTOM: Byte = 4
    }
    private var anim: Byte = 0

    fun setAnim(anim: Byte): RecyclerAnim {
        this.anim = anim
        return this
    }

    private var recyclerView: WeakReference<RecyclerView>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var pocketAdapter: PocketAdapter? = null

    init {
        this.layoutManager = RecyclerLinearLayoutManager(fragmentActivity.get()!!, LinearLayoutManager.VERTICAL, false)
        this.anim = SLIDE_BOTTOM
    }
    fun commit(): RecyclerAnim {
        var adapter: AnimationAdapter? = null
        when (anim) {
            ALPHA_IN -> adapter = AlphaInAnimationAdapter(pocketAdapter)
            SCALE_IN -> adapter = ScaleInAnimationAdapter(pocketAdapter)
            SLIDE_BOTTOM -> adapter = SlideInBottomAnimationAdapter(pocketAdapter)
            SLIDE_LEFT -> adapter = SlideInLeftAnimationAdapter(pocketAdapter)
            SLIDE_RIGHT -> adapter = SlideInRightAnimationAdapter(pocketAdapter)
        }
        adapter!!.setDuration(1000)
        adapter.setFirstOnly(false)
        adapter.setInterpolator(OvershootInterpolator())

        recyclerView!!.get()!!.adapter = adapter
        recyclerView!!.get()!!.layoutManager = layoutManager
        adapter = null
        recyclerView = null
        return this
    }

    fun setRecyclerView(recyclerView: WeakReference<RecyclerView>): RecyclerAnim {
        this.recyclerView = recyclerView
        return this
    }

    fun setPocketAdapter(pocketAdapter: PocketAdapter): RecyclerAnim {
        this.pocketAdapter = pocketAdapter
        return this
    }

    fun setLayoutManager(layoutManager: RecyclerView.LayoutManager): RecyclerAnim {
        this.layoutManager = layoutManager
        return this
    }


}
