package library.jdp.jdppattern.base


import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.Unbinder
import java.util.*

abstract class TabbedFragment : Fragment(), ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener {
    private var unbinder: Unbinder? = null
    var rootView: View? = null
    var viewPager: ViewPager? = null
    private var pocketViewPagerAdapter: PocketViewPagerAdapter?=null
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
        pocketViewPagerAdapter = PocketViewPagerAdapter(childFragmentManager,fragmentList,titleList)
        viewPager!!.adapter = pocketViewPagerAdapter
        initTabLayout().setupWithViewPager(viewPager)
        if(initPageTransformer()!=null)
            viewPager!!.setPageTransformer(true, initPageTransformer())
        viewPager!!.addOnPageChangeListener(this)
        initComponents()
        initServices()
        return rootView
    }

    override fun onDestroyView() {
        viewPager=null
        pocketViewPagerAdapter=null
        titleList!!.clear()
        fragmentList!!.clear()
        titleList=null
        fragmentList=null
        unbinder!!.unbind()
        unbinder=null
        super.onDestroyView()
    }

    override fun onTabSelected(tab: TabLayout.Tab) {}
    override fun onTabUnselected(tab: TabLayout.Tab) {}
    override fun onTabReselected(tab: TabLayout.Tab) {}
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
    override fun onPageSelected(position: Int) {}
    override fun onPageScrollStateChanged(state: Int) {}
    fun showDialog(intent: Intent){
        activity.startActivity(intent)
    }

}