package com.touchsurgery.thesurgeonstodolist.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.support.v7.widget.Toolbar
import com.touchsurgery.thesurgeonstodolist.presenter.MainActivityPresenter
import com.touchsurgery.thesurgeonstodolist.utils.Item
import com.touchsurgery.thesurgeonstodolist.R


class MainActivity : AppCompatActivity(), MainActivityPresenter.View {

    val presenter: MainActivityPresenter = MainActivityPresenter(this)
    private lateinit var listFragment: ListFragment
    private lateinit var addItemFragment: AddItemFragment
    lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = resources.getString(R.string.app_name)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        fab = findViewById(R.id.fab)
        fab.setOnClickListener {
            loadItemFragment()
        }

        listFragment = ListFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content, listFragment)
        fragmentTransaction.commit()
    }

    private fun loadItemFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        addItemFragment = AddItemFragment()
        fragmentTransaction.replace(R.id.content, addItemFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onAddItem() {
        supportFragmentManager.popBackStackImmediate()
    }

    override fun updateList(list: ArrayList<Item>) {
        listFragment.updateList(list)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
