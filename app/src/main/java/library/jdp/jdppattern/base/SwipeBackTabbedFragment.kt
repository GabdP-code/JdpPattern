package library.jdp.jdppattern.base

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.Unbinder
import me.yokeyword.swipebackfragment.SwipeBackFragment
import java.util.*

/**
 * Created by jamesdeperio on 7/5/2017.
 */

abstract class SwipeBackTabbedFragment : SwipeBackFragment(), ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener {
    private var unbinder: Unbinder? = null
    var rootView: View? = null
    var viewPager: ViewPager? = null
    //private var pocketViewPagerAdapter: PocketViewPagerAdapter?=null
    private var titleList: MutableList<String>?=null
    private var fragmentList: MutableList<Fragment>? = null
    fun addPage(title: String, fragment: Fragment) {
        titleList!!.add(title)
        fragmentList!!.add(fragment)
    }

    protected abstract fun initContentView(): Any
    protected abstract fun initTabLayout(): TabLayout
    protected abstract fun initViewPager(): ViewPager
    protected abstract fun initPages()
    protected abstract fun initPageTransformer(): ViewPager.PageTransformer?
    protected abstract fun initComponents()
    protected abstract fun initServices()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(Integer.parseInt(initContentView().toString()), container, false)
        titleList = ArrayList<String>()
        fragmentList = ArrayList<Fragment>()
        initPages()
        viewPager = initViewPager()
        val pocketViewPagerAdapter = PocketViewPagerAdapter(fragmentManager)
        viewPager!!.adapter = pocketViewPagerAdapter
        initTabLayout().setupWithViewPager(viewPager)
        if(initPageTransformer()!=null)
        viewPager!!.setPageTransformer(true, initPageTransformer())
        viewPager!!.addOnPageChangeListener(this)
        initComponents()
        initServices()
        return attachToSwipeBack(rootView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder!!.unbind()
    }

    override fun onTabSelected(tab: TabLayout.Tab) {}
    override fun onTabUnselected(tab: TabLayout.Tab) {}
    override fun onTabReselected(tab: TabLayout.Tab) {}
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
    override fun onPageSelected(position: Int) {}
    override fun onPageScrollStateChanged(state: Int) {}

    inner class PocketViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment? {
            var x = 0
            for (fragment in fragmentList!!) {
                if (x == position) return fragment
                x++
            }
            return null
        }
        override fun getCount(): Int {
            return titleList!!.size
        }
        override fun getPageTitle(position: Int): CharSequence? {
            var x = 0
            for (title in titleList!!) {
                if (x == position) return title
                x++
            }
            return null
        }
    }
    fun showDialog(intent: Intent){
        activity.startActivity(intent)
    }
}

