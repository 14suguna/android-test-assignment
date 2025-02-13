package com.touchsurgery.thesurgeonstodolist

import android.util.Log
import android.widget.ListView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.longClick
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.touchsurgery.thesurgeonstodolist.activities.MainActivity
import com.touchsurgery.thesurgeonstodolist.utils.SeekBarAction
import org.hamcrest.Matchers.anything
import org.junit.Rule
import org.junit.Test


class TodoListDeleteTest {

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun addAndDeleteTasks() {
        // Step 1: Get initial list size before adding new tasks (default tasks)
        val initialListSize = getListItems().size
        Log.d("TodoListDeleteTest", "Initial list size (default tasks): $initialListSize")

        val newTasks = listOf(
            Triple("Diagnose flaky tests", "High", 9),
            Triple("Check system pulse", "Low", 1),
            Triple("Perform code surgery", "Medium", 5)
        )

        // Step 2: Add new tasks
        newTasks.forEach { (taskName, _, seekBarValue) ->
            addTask(taskName, seekBarValue)
        }

//        Thread.sleep(1000) // Wait for UI update

        // Step 3: Get updated list and filter only newly added tasks
        val updatedList = getListItems()
        val newItems = updatedList.drop(initialListSize)
        Log.d("TodoListDeleteTest", "Newly added items: $newItems")

        if (newItems.isEmpty()) {
            throw AssertionError("No new tasks were added!")
        }

        // --- Case 1: Delete One Newly Added Task ---
        deleteSpecificTask("Diagnose flaky tests")

        // --- Case 2: Delete All Tasks (Both Default & Newly Added) ---
        deleteAllTasks()

        // Step 4: Verify that all tasks are deleted
        val finalList = getListItems()
        Log.d("TodoListDeleteTest", "Final List After Deleting Everything: $finalList")

        assert(finalList.isEmpty()) { "Expected list to be empty, but found ${finalList.size} items" }
    }

    /**
     * Helper function to add a task with a given priority (SeekBar value).
     */
    private fun addTask(taskName: String, priorityValue: Int) {
        onView(withId(R.id.fab)).perform(click()) // Open input form

        // Enter task description
        onView(withId(R.id.todoText)).perform(typeText(taskName), closeSoftKeyboard())

        // Set SeekBar priority (Slider)
        onView(withId(R.id.seekBar)).perform(SeekBarAction(priorityValue))

        // Click "Add Item" button
        onView(withId(R.id.submitTodo)).perform(click())
    }

    /**
     * Deletes a specific task from the list if it exists.
     */
    private fun deleteSpecificTask(taskName: String) {
        val listItems = getListItems()
        val positionToDelete = listItems.indexOf(taskName)

        if (positionToDelete != -1) {
            Log.d(
                "TodoListDeleteTest",
                "Deleting task: $taskName at position $positionToDelete"
            )
            onData(anything())
                .inAdapterView(withId(R.id.list))
                .atPosition(positionToDelete)
                .perform(longClick())
            Thread.sleep(1000)
            val updatedList = getListItems()
            if (updatedList.contains(taskName)) {
                throw java.lang.AssertionError("Task '$taskName' was not deleted successfully!")
            }
        } else {
            Log.d("TodoListDeleteTest", "Task '$taskName' not found. Skipping deletion.")
        }
    }

    /**
     * Deletes all tasks from the list.
     */
    private fun deleteAllTasks() {
        var listItems = getListItems()
        while (listItems.isNotEmpty()) {
            Log.d("TodoListDeleteTest", "Deleting all tasks, remaining: ${listItems.size}")

            // Always delete the first task in the list
            onData(anything())
                .inAdapterView(withId(R.id.list))
                .atPosition(0)
                .perform(longClick())


            // Refresh the list after deletion
            listItems = getListItems()
        }
    }

    /**
     * Helper function to retrieve all list items dynamically.
     */
    private fun getListItems(): List<String> {
        val taskList = mutableListOf<String>()
        activityRule.scenario.onActivity { activity ->
            val listView = activity.findViewById<ListView>(R.id.list)
            val adapter = listView.adapter
            for (i in 0 until adapter.count) {
                taskList.add(adapter.getItem(i).toString())
            }
        }
        return taskList
    }
}
