package library.jdp.jdplib.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by jamesdeperio on 2/5/2017.
 */

abstract class PocketAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(), AdapterContract {
    protected val TYPE_HEADER: Byte = 0
    protected val TYPE_FOOTER: Byte = 1
    protected val TYPE_ITEM_SIMPLE: Byte = 2
    protected val TYPE_ITEM_IMAGE: Byte = 3
    protected val TYPE_ITEM_VIDEO: Byte = 4

    protected var layoutHeader: Int = 0
    protected var layoutFooter: Int = 0
    protected var layoutSimple: Int = 0
    protected var layoutImage: Int = 0
    protected var layoutVideo: Int = 0

    override fun isFooterSet(): Boolean {
        return this.layoutFooter != 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        if (viewType == TYPE_HEADER.toInt()) {
            view = LayoutInflater.from(parent.context).inflate(layoutHeader, parent, false)
            return HeaderLayout(view)
        } else if (viewType == TYPE_FOOTER.toInt()) {
            view = LayoutInflater.from(parent.context).inflate(layoutFooter, parent, false)
            return FooterLayout(view)
        } else if (viewType == TYPE_ITEM_IMAGE.toInt()) {
            view = LayoutInflater.from(parent.context).inflate(layoutImage, parent, false)
            return ItemImageLayout(view)
        } else if (viewType == TYPE_ITEM_VIDEO.toInt()) {
            view = LayoutInflater.from(parent.context).inflate(layoutVideo, parent, false)
            return ItemVideoLayout(view)
        }
        view = LayoutInflater.from(parent.context).inflate(layoutSimple, parent, false)
        return SimpleItemLayout(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        try {
            if (holder is HeaderLayout) {
                bindHeaderLayout(holder.itemView, position)
            } else if (holder is FooterLayout) {
                bindFooterLayout(holder.itemView, position)
            } else if (holder is SimpleItemLayout) {
                bindSimpleItemLayout(holder.itemView, position)
            } else if (holder is ItemImageLayout) {
                bindItemImageLayout(holder.itemView, position)
            } else if (holder is ItemVideoLayout) {
                bindItemVideoLayout(holder.itemView, position)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
    protected abstract fun bindSimpleItemLayout(holder: View, position: Int)
    protected fun bindHeaderLayout(holder: View, position: Int) {}
    protected fun bindFooterLayout(holder: View, position: Int) {}
    protected fun bindItemImageLayout(holder: View, position: Int) {}
    protected fun bindItemVideoLayout(holder: View, position: Int) {}


    override fun getItemViewType(position: Int): Int {
        return ViewTypeCondition(position)
    }

    protected fun ViewTypeCondition(position: Int): Int {
        return TYPE_ITEM_SIMPLE.toInt()
    }

    protected abstract val dataCount: Int
    override fun getItemCount(): Int {
        return dataCount
    }

    internal inner class HeaderLayout(itemView: View) : RecyclerView.ViewHolder(itemView)
    internal inner class FooterLayout(itemView: View) : RecyclerView.ViewHolder(itemView)
    internal inner class SimpleItemLayout(itemView: View) : RecyclerView.ViewHolder(itemView)
    internal inner class ItemImageLayout(itemView: View) : RecyclerView.ViewHolder(itemView)
    internal inner class ItemVideoLayout(itemView: View) : RecyclerView.ViewHolder(itemView)
}