package com.touchsurgery.thesurgeonstodolist.tests

import android.util.Log
import android.widget.ListView
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.touchsurgery.thesurgeonstodolist.R
import com.touchsurgery.thesurgeonstodolist.activities.MainActivity
import com.touchsurgery.thesurgeonstodolist.robots.TodoListPriorityRobot
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class TodoListPriorityRobotTest {

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    private val robot = TodoListPriorityRobot()

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
            robot.addTask(taskName, priority)
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
