package com.touchsurgery.thesurgeonstodolist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import androidx.appcompat.widget.Toolbar
import com.touchsurgery.thesurgeonstodolist.R
import com.touchsurgery.thesurgeonstodolist.utils.SharedPreferencesManager

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        title = resources.getString(R.string.action_settings)

        val prefs = SharedPreferencesManager(this)
        val orderType = prefs.getOrderType()
        when(orderType) {
            SharedPreferencesManager.ORDER_TYPE_NAME -> findViewById<RadioGroup>(R.id.radioGroup).check(findViewById<RadioButton>(R.id.radioSortName).id)
            SharedPreferencesManager.ORDER_TYPE_PRIORITY -> findViewById<RadioGroup>(R.id.radioGroup).check(findViewById<RadioButton>(R.id.radioSortPriority).id)
        }
        findViewById<RadioGroup>(R.id.radioGroup).setOnCheckedChangeListener { _, checkedId ->
            when(checkedId) {
                findViewById<RadioButton>(R.id.radioSortName).id -> prefs.setOrderType(SharedPreferencesManager.ORDER_TYPE_NAME)
                findViewById<RadioButton>(R.id.radioSortPriority).id -> prefs.setOrderType(SharedPreferencesManager.ORDER_TYPE_PRIORITY)
            }
        }

        val orderAscending = prefs.getOrderAscending()
        findViewById<Switch>(R.id.switchAscending).isChecked = orderAscending
        findViewById<Switch>(R.id.switchAscending).text = if(orderAscending) resources.getString(R.string.ascending)
        else resources.getString(R.string.descending)
        findViewById<Switch>(R.id.switchAscending).setOnCheckedChangeListener{ view, isChecked ->
            view.text = if(isChecked) resources.getString(R.string.ascending)
            else resources.getString(R.string.descending)
            prefs.setOrderAscending(isChecked)
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }
}
