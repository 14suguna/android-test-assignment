package com.touchsurgery.thesurgeonstodolist.robots

import android.util.Log
import android.widget.ListView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import com.touchsurgery.thesurgeonstodolist.R
import com.touchsurgery.thesurgeonstodolist.utils.SeekBarAction
import org.hamcrest.Matchers.anything
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.touchsurgery.thesurgeonstodolist.activities.MainActivity

class TodoListDeleteRobot {

    lateinit var activityRule: ActivityScenarioRule<MainActivity>

    /**
     * Adds a new task with the given priority.
     */
    fun addTask(taskName: String, priorityValue: Int): TodoListDeleteRobot {
        onView(withId(R.id.fab)).perform(click()) // Open input form
        onView(withId(R.id.todoText)).perform(typeText(taskName), closeSoftKeyboard()) // Enter task description
        onView(withId(R.id.seekBar)).perform(SeekBarAction(priorityValue)) // Set SeekBar priority
        onView(withId(R.id.submitTodo)).perform(click()) // Submit task

        // Wait for UI update
        waitUntilListUpdates()

        return this
    }

    /**
     * Deletes a specific task if it exists.
     */
    fun deleteSpecificTask(taskName: String): TodoListDeleteRobot {
        val listItems = getListItems()
        val positionToDelete = listItems.indexOfFirst { it.contains(taskName, ignoreCase = true) }

        if (positionToDelete != -1) {
            Log.d("TodoListDeleteRobot", "Deleting task '$taskName' at position $positionToDelete")

            onData(anything())
                .inAdapterView(withId(R.id.list))
                .atPosition(positionToDelete)
                .perform(longClick())

            // Wait for UI update
            waitUntilListUpdates()

            val updatedList = getListItems()
            if (!updatedList.contains(taskName)) {
                Log.d("TodoListDeleteRobot", "Task '$taskName' deleted successfully!")
            } else {
                throw AssertionError("Task '$taskName' was not deleted successfully!")
            }
        } else {
            Log.e("TodoListDeleteRobot", "Task '$taskName' not found. Skipping deletion.")
        }
        return this
    }

    /**
     * Deletes all tasks from the list.
     */
    fun deleteAllTasks(): TodoListDeleteRobot {
        var listItems = getListItems()
        while (listItems.isNotEmpty()) {
            Log.d("TodoListDeleteRobot", "Deleting all tasks, remaining: ${listItems.size}")

            onData(anything())
                .inAdapterView(withId(R.id.list))
                .atPosition(0)
                .perform(longClick())

            // Wait for UI update
            waitUntilListUpdates()

            // Refresh the list after deletion
            listItems = getListItems()
        }
        return this
    }

    /**
     * Retrieves all task items dynamically.
     */
    fun getListItems(): List<String> {
        val taskList = mutableListOf<String>()
        activityRule.scenario.onActivity { activity ->
            val listView = activity.findViewById<ListView>(R.id.list)
            val adapter = listView.adapter

            if (adapter != null) {
                for (i in 0 until adapter.count) {
                    taskList.add(adapter.getItem(i).toString())
                }
            }
        }
        Log.d("TodoListDeleteRobot", "Current List Items: $taskList")
        return taskList
    }

    /**
     * Waits until the list updates dynamically.
     */
    private fun waitUntilListUpdates() {
        Thread.sleep(1000) // Small delay for UI update
    }
}
