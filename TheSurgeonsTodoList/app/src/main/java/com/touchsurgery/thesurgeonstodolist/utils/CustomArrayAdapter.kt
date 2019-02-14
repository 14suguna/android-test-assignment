package com.touchsurgery.thesurgeonstodolist.utils

import android.content.Context
import android.widget.TextView
import android.view.ViewGroup
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import com.touchsurgery.thesurgeonstodolist.R


class CustomArrayAdapter(private val mContext: Context, @LayoutRes list: ArrayList<Item>) :
    ArrayAdapter<Item>(mContext, 0, list) {
    private var itemList = ArrayList<Item>()

    init {
        itemList = list
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val listItem: View
        if (convertView == null) {
            val item = itemList[position]
            listItem = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1 ,parent,false)
            listItem.findViewById<TextView>(android.R.id.text1).text =
                mContext.resources.getString(R.string.list_item).format(item.priority, item.text)
        } else {
            listItem = convertView
        }

        return listItem
    }
}