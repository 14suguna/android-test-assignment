package com.touchsurgery.thesurgeonstodolist.presenter

import com.touchsurgery.thesurgeonstodolist.dagger.MainActivityPresenterModule
import com.touchsurgery.thesurgeonstodolist.utils.Item
import dagger.Component

@Component(modules=[MainActivityPresenterModule::class])
interface AppComponent {
    fun provideDefaultListItems(): ArrayList<Item>
}

class MainActivityPresenter(private val view: View) {

    var list: ArrayList<Item>

    init {
        val appComponent: AppComponent = DaggerAppComponent.builder()
            .mainActivityPresenterModule(MainActivityPresenterModule())
            .build()
        list = appComponent.provideDefaultListItems()
    }

    fun addItem(item: Item) {
        list.add(item)
        view.onAddItem()
    }

    fun removeItem(pos: Int) {
        list.removeAt(pos)
        updateList()
    }

    fun updateList() {
        view.updateList(list)
    }

    interface View {
        fun onAddItem()
        fun updateList(list: ArrayList<Item>)
    }
}