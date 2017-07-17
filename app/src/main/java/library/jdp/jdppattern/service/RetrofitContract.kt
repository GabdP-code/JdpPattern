package library.jdp.jdppattern.service

/**
 * Created by jamesdeperio on 7/5/2017.
 */

internal interface RetrofitContract {
    fun setCacheSize(): Int
    fun setBaseURL(): String
}