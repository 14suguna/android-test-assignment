package com.example.surgeontodo.robots

import GetTextAction
import android.util.Log
import android.widget.ListView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.touchsurgery.thesurgeonstodolist.R
import com.touchsurgery.thesurgeonstodolist.utils.SeekBarAction
import org.hamcrest.Matchers.anything

class TodoListSettingsRobot {

    fun addTask(taskName: String, priority: Int): TodoListSettingsRobot {
        onView(withId(R.id.fab)).perform(click()) // Open input form
        onView(withId(R.id.todoText)).perform(typeText(taskName), closeSoftKeyboard()) // Enter task name
        onView(withId(R.id.seekBar)).perform(SeekBarAction(priority)) // Set priority level
        onView(withId(R.id.submitTodo)).perform(click()) // Submit task
        return this
    }

    fun openSettings(): TodoListSettingsRobot {
        onView(withContentDescription("More options")).perform(click()) // Open menu
        onView(withText("Settings")).perform(click()) // Click "Settings"
        return this
    }

    fun changeSortingToPriority(): TodoListSettingsRobot {
        onView(withId(R.id.radioSortPriority)).perform(click()) // Select priority sorting
        return this
    }

    fun toggleSortingDirection(): TodoListSettingsRobot {
        onView(withId(R.id.switchAscending)).perform(click()) // Toggle sorting direction
        return this
    }

    fun goBackToMainScreen(): TodoListSettingsRobot {
        Log.d("TodoListSettingsRobot", "Attempting to go back to main screen")
        pressBack() // Simply press back once
        return this
    }

    fun getListSize(): Int {
        var itemCount = 0
        try {
            onView(withId(R.id.list)).check { view, _ ->
                val listView = view as ListView
                itemCount = listView.adapter?.count ?: 0
            }
        } catch (e: Exception) {
            Log.e("TodoListSettingsRobot", "Error getting list size", e)
        }

        Log.d("TodoListSettingsRobot", "List contains $itemCount items")
        return itemCount
    }

    fun getListItemText(position: Int): String {
        var itemText = ""
        try {
            onData(anything())
                .inAdapterView(withId(R.id.list))
                .atPosition(position)
                .perform(GetTextAction { text -> itemText = text })
        } catch (e: Exception) {
            Log.e("TodoListSettingsRobot", "Error fetching item text at position $position", e)
        }
        return itemText
    }

    fun waitUntilListIsPopulated(expectedSize: Int) {
        var itemCount = 0
        val maxAttempts = 10
        var attempts = 0

        while (itemCount < expectedSize && attempts < maxAttempts) {
            Thread.sleep(500) // Allow UI update
            itemCount = getListSize()
            attempts++
        }

        if (itemCount < expectedSize) {
            throw AssertionError("List did not populate in time. Expected: $expectedSize, Found: $itemCount")
        }
    }

}
