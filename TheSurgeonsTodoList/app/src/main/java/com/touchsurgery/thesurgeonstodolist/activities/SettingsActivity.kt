package com.touchsurgery.thesurgeonstodolist.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.touchsurgery.thesurgeonstodolist.R
import com.touchsurgery.thesurgeonstodolist.utils.SharedPreferencesManager
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        title = resources.getString(R.string.action_settings)

        val prefs = SharedPreferencesManager(this)
        val orderType = prefs.getOrderType()
        when(orderType) {
            SharedPreferencesManager.ORDER_TYPE_NAME -> radioGroup.check(radioSortName.id)
            SharedPreferencesManager.ORDER_TYPE_PRIORITY -> radioGroup.check(radioSortPriority.id)
        }
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId) {
                radioSortName.id -> prefs.setOrderType(SharedPreferencesManager.ORDER_TYPE_NAME)
                radioSortPriority.id -> prefs.setOrderType(SharedPreferencesManager.ORDER_TYPE_PRIORITY)
            }
        }

        val orderAscending = prefs.getOrderAscending()
        switchAscending.isChecked = orderAscending
        switchAscending.text = if(orderAscending) resources.getString(R.string.ascending)
        else resources.getString(R.string.descending)
        switchAscending.setOnCheckedChangeListener{ view, isChecked ->
            view.text = if(isChecked) resources.getString(R.string.ascending)
            else resources.getString(R.string.descending)
            prefs.setOrderAscending(isChecked)
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }
}
