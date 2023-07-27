package com.touchsurgery.thesurgeonstodolist.activities

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SeekBar
import android.widget.TextView
import com.touchsurgery.thesurgeonstodolist.utils.CustomArrayAdapter
import com.touchsurgery.thesurgeonstodolist.utils.Item
import com.touchsurgery.thesurgeonstodolist.R
import com.touchsurgery.thesurgeonstodolist.utils.SharedPreferencesManager
import java.util.Locale

class ListFragment : Fragment() {

    private lateinit var adapter: CustomArrayAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ListView>(R.id.list).setOnItemClickListener { _, _, position, _ ->
            (activity as MainActivity).presenter.removeItem(position)
        }
        (activity as MainActivity).fab.show()
    }

    fun updateList(arrayList: ArrayList<Item>) {
        val prefs = SharedPreferencesManager(requireContext())
        val orderType = prefs.getOrderType()
        val orderAscending = prefs.getOrderAscending()
        when (orderType) {
            SharedPreferencesManager.ORDER_TYPE_NAME -> {
                if (orderAscending)
                    arrayList.sortBy { it.text.lowercase(Locale.getDefault()) }
                else
                    arrayList.sortByDescending { it.text.lowercase(Locale.getDefault()) }
            }
            SharedPreferencesManager.ORDER_TYPE_PRIORITY -> {
                if (orderAscending)
                    arrayList.sortBy { it.priority }
                else
                    arrayList.sortByDescending { it.priority }
            }
        }
        view?.findViewById<TextView>(R.id.noItemsLabel)?.visibility = View.GONE
        adapter = CustomArrayAdapter(requireContext(), arrayList)
        view?.findViewById<ListView>(R.id.list)?.adapter = adapter
        adapter.notifyDataSetChanged()
        if(arrayList.size <= 0) {
            view?.findViewById<TextView>(R.id.noItemsLabel)?.visibility = View.VISIBLE
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).presenter.updateList()
    }
}
