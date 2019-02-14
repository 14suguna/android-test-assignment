package com.touchsurgery.thesurgeonstodolist.dagger

import com.touchsurgery.thesurgeonstodolist.utils.Item
import dagger.Module
import dagger.Provides


@Module
class MainActivityPresenterModule {

    @Provides
    fun provideDefaultListItems(): ArrayList<Item> {
        val list: ArrayList<Item> = arrayListOf()
        list.add(Item(5, "Treat patients"))
        list.add(Item(10, "Try those amazing surgery mobile apps"))
        return list
    }
}
