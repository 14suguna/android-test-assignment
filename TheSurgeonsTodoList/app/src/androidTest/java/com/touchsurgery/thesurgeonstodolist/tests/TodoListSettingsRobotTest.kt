package com.touchsurgery.thesurgeonstodolist.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.surgeontodo.robots.TodoListSettingsRobot
import com.touchsurgery.thesurgeonstodolist.activities.MainActivity
import org.junit.Assert.assertNotEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.util.Log

@RunWith(AndroidJUnit4::class)
class TodoListSettingsRobotTest {

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    private val robot = TodoListSettingsRobot()

    @Test
    fun testVerifySortingDynamically() {
        Log.i("TodoListTest", "Starting test: Verify Sorting Dynamically")

        // Add multiple tasks with priorities
        val taskList = listOf(
            Triple("Diagnose flaky tests", "High", 9),
            Triple("Inject test data", "Low", 2),
            Triple("Check system pulse", "High", 8),
            Triple("Prescribe bug fixes", "Medium", 6)
        )

        taskList.forEach { (taskName, _, priority) ->
            robot.addTask(taskName, priority)
        }

        // Ensure all tasks are added before proceeding
        robot.waitUntilListIsPopulated(taskList.size)

        // Get total number of items dynamically
        var totalItems = robot.getListSize()
        if (totalItems < 2) {
            throw AssertionError("Not enough items to verify sorting (Before sorting)")
        }

        // Get all items before sorting
        val itemsBeforeSort = (0 until totalItems).map { robot.getListItemText(it) }
        Log.d("TodoListTest", "Items Before Sorting: $itemsBeforeSort")

        // Open settings and change sorting order
        robot.openSettings()
            .changeSortingToPriority()
            .toggleSortingDirection()
            .goBackToMainScreen()

        // Wait for sorting to apply
        Log.i("TodoListTest", "Waiting for sorting to apply...")
        Thread.sleep(3000)

        // Retry fetching sorted list to ensure it's updated
        robot.waitUntilListIsPopulated(totalItems)

        // Fetch the list again after sorting
        totalItems = robot.getListSize()
        if (totalItems < 2) {
            throw AssertionError("Not enough items to verify sorting (After sorting)")
        }

        // Get all items after sorting
        val itemsAfterSort = (0 until totalItems).map { robot.getListItemText(it) }
        Log.i("TodoListTest", "Items After Sorting: $itemsAfterSort")

        // Assert sorting changed
        assertNotEquals("Sorting order did not change!", itemsBeforeSort, itemsAfterSort)

        println("Items Before Sorting: $itemsBeforeSort")
        println("Items After Sorting: $itemsAfterSort")


        Log.i("TodoListTest", "Test completed successfully")
    }
}
