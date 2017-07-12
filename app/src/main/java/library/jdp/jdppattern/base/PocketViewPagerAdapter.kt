package library.jdp.jdplib.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter



/**
 * Created by jamesdeperio on 7/11/2017.
 */
class PocketViewPagerAdapter(fm: FragmentManager, private var fragmentList: MutableList<Fragment>?, private var titleList: MutableList<String>?) : FragmentPagerAdapter(fm) {
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