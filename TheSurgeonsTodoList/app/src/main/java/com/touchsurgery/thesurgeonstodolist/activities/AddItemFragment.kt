package com.touchsurgery.thesurgeonstodolist.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.touchsurgery.thesurgeonstodolist.utils.Item
import com.touchsurgery.thesurgeonstodolist.R
import kotlinx.android.synthetic.main.fragment_item.*

class AddItemFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submitTodo?.setOnClickListener {
            val item = Item(seekBar.progress, todoText.text.toString())
            (activity as MainActivity).presenter.addItem(item)
        }
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                priorityValue.text = i.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        seekBar.progress = 0
        (activity as MainActivity).fab.hide()
    }
}