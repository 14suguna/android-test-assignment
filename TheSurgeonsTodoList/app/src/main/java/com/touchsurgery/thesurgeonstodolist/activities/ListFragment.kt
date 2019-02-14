package com.touchsurgery.thesurgeonstodolist.activities

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.touchsurgery.thesurgeonstodolist.utils.CustomArrayAdapter
import com.touchsurgery.thesurgeonstodolist.utils.Item
import com.touchsurgery.thesurgeonstodolist.R
import com.touchsurgery.thesurgeonstodolist.utils.SharedPreferencesManager
import kotlinx.android.synthetic.main.fragment_main.*

class ListFragment : Fragment() {

    private lateinit var adapter: CustomArrayAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.setOnItemClickListener { _, _, position, _ ->
            (activity as MainActivity).presenter.removeItem(position)
        }
        (activity as MainActivity).fab.show()
    }

    fun updateList(arrayList: ArrayList<Item>) {
        if(arrayList.size > 0) {
            val prefs = SharedPreferencesManager(context!!)
            val orderType = prefs.getOrderType()
            val orderAscending = prefs.getOrderAscending()
            when (orderType) {
                SharedPreferencesManager.ORDER_TYPE_NAME -> {
                    if (orderAscending)
                        arrayList.sortBy { it.text.toLowerCase() }
                    else
                        arrayList.sortByDescending { it.text.toLowerCase() }
                }
                SharedPreferencesManager.ORDER_TYPE_PRIORITY -> {
                    if (orderAscending)
                        arrayList.sortBy { it.priority }
                    else
                        arrayList.sortByDescending { it.priority }
                }
            }
            noItemsLabel.visibility = View.GONE
            adapter = CustomArrayAdapter(context!!, arrayList)
            list.adapter = adapter
            adapter.notifyDataSetChanged()
        } else {
            noItemsLabel.visibility = View.VISIBLE
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).presenter.updateList()
    }
}
