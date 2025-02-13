package com.touchsurgery.thesurgeonstodolist

import android.util.Log
import android.widget.ListView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.touchsurgery.thesurgeonstodolist.activities.MainActivity
import com.touchsurgery.thesurgeonstodolist.utils.SeekBarAction
import org.junit.Rule
import org.junit.Test
import org.junit.After
import org.junit.Assert.assertTrue

class TodoListPriorityTest {

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testAddTasksWithPriorities() {
        // Initial task list
        val initialTaskList = getTaskList()
        Log.d("TodoListPriorityTest", "Initial Task List: $initialTaskList")

        // Define tasks with different priorities
        val tasks = listOf(
            Triple("Task A", "High", 9),
            Triple("Task B", "Medium", 5),
            Triple("Task C", "Low", 1)
        )

        // Add each task
        tasks.forEach { (taskName, _, priority) ->
            addTask(taskName, priority)
        }


        // Fetch updated task list
        val updatedTaskList = getTaskList()
        Log.d("TodoListPriorityTest", "Updated Task List: $updatedTaskList")

        // Check new tasks are added
        tasks.forEach { (taskName, _, _) ->
            assertTrue("Task '$taskName' not found!", updatedTaskList.any { it.contains(taskName) })
        }
    }

    /**
     * Adds a new task with a given priority.
     */
    private fun addTask(taskName: String, priority: Int) {
        onView(withId(R.id.fab)).perform(click()) // Open input form
        onView(withId(R.id.todoText)).perform(typeText(taskName), closeSoftKeyboard()) // Enter task description
        onView(withId(R.id.seekBar)).perform(SeekBarAction(priority)) // Set SeekBar priority
        onView(withId(R.id.submitTodo)).perform(click()) // Submit task
    }

    /**
     * Retrieves all task list items.
     */
    private fun getTaskList(): List<String> {
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

    /**
     * Check the activity is finished after the test.
     */
    @After
    fun tearDown() {
        activityRule.scenario.onActivity { it.finish() }
    }
}
