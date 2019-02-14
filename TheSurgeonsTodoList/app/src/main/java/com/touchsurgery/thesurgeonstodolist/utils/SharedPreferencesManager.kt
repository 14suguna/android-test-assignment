package com.touchsurgery.thesurgeonstodolist.utils

import android.content.Context

class SharedPreferencesManager(context: Context) {

    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    companion object {
        const val PREFS_NAME = "prefs"
        const val PREF_ORDER = "order"
        const val PREF_ASCENDING = "ascending"
        const val ORDER_TYPE_NAME = 0
        const val ORDER_TYPE_PRIORITY = 1
    }

    fun setOrderType(orderType: Int) {
        prefs.edit().putInt(PREF_ORDER, orderType).apply()
    }

    fun setOrderAscending(ascending: Boolean) {
        prefs.edit().putBoolean(PREF_ASCENDING, ascending).apply()
    }

    fun getOrderType() = prefs.getInt(
        PREF_ORDER,
        ORDER_TYPE_NAME
    )

    fun getOrderAscending() = prefs.getBoolean(
        PREF_ASCENDING,
        true
    )

}