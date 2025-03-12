package com.touchsurgery.thesurgeonstodolist.tests

import android.util.Log
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.touchsurgery.thesurgeonstodolist.activities.MainActivity
import com.touchsurgery.thesurgeonstodolist.robots.TodoListDeleteRobot
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TodoListDeleteRobotTest {

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    private val robot = TodoListDeleteRobot()
    private lateinit var initialList: List<String>

    @Before
    fun setup() {
        robot.activityRule = activityRule // Assign Activity Rule

        // Capture the initial list items BEFORE adding new ones
        initialList = robot.getListItems().map { it.substringAfter("text=") }.map { it.removeSuffix(")") }
        Log.d("TodoListDeleteTest", "Initial list before adding new tasks: $initialList")
    }

    @Test
    fun addAndDeleteTasks() {
        Log.d("TodoListDeleteTest", "Starting addAndDeleteTasks test")

        // Step 1: Add new tasks
        val newTasks = listOf(
            Triple("Diagnose flaky tests", "High", 9),
            Triple("Check system pulse", "Low", 1),
            Triple("Perform code surgery", "Medium", 5)
        )

        newTasks.forEach { (taskName, _, seekBarValue) ->
            robot.addTask(taskName, seekBarValue)
        }

        // Step 2: Wait until new tasks are visible
        Thread.sleep(2000) // Allow UI to update

        // Step 3: Verify new tasks were added
        val updatedList = robot.getListItems().map { it.substringAfter("text=") }.map { it.removeSuffix(")") }
        Log.d("TodoListDeleteTest", "Updated List After Adding Tasks: $updatedList")

        // **Fix**: Remove default tasks and keep only the newly added ones
        val newItems = updatedList.filter { it !in initialList }
        Log.d("TodoListDeleteTest", "Filtered newly added items: $newItems")

        if (newItems.isEmpty()) {
            throw AssertionError("No new tasks were added!")
        }

        // Step 4: Delete a specific task (Ensure it exists)
        val taskToDelete = "Diagnose flaky tests"

        if (newItems.contains(taskToDelete)) {
            robot.deleteSpecificTask(taskToDelete)
        } else {
            throw AssertionError("Task '$taskToDelete' not found in the list! Current list: $newItems")
        }

        // Step 5: Verify the task is deleted
        val listAfterSingleDelete = robot.getListItems().map { it.substringAfter("text=") }.map { it.removeSuffix(")") }
        Log.d("TodoListDeleteTest", "List After Deleting '$taskToDelete': $listAfterSingleDelete")
        assert(!listAfterSingleDelete.contains(taskToDelete)) { "Task '$taskToDelete' was not deleted!" }

        // Step 6: Delete all remaining added tasks (excluding default tasks)
        newItems.forEach { robot.deleteSpecificTask(it) }

        // Step 7: Verify all newly added tasks are deleted
        val finalList = robot.getListItems().map { it.substringAfter("text=") }.map { it.removeSuffix(")") }
        Log.d("TodoListDeleteTest", "Final List After Deleting Everything: $finalList")

        assert(finalList == initialList) { "Expected only default tasks to remain, but found $finalList" }

        Log.d("TodoListDeleteTest", "Test completed successfully")
    }

    @After
    fun tearDown() {
        activityRule.scenario.onActivity { it.finish() }
    }
}
