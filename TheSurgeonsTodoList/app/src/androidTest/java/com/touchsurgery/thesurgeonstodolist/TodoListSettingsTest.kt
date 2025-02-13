package com.example.surgeontodo.tests

import GetTextAction
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.touchsurgery.thesurgeonstodolist.R
import com.touchsurgery.thesurgeonstodolist.activities.MainActivity
import org.hamcrest.Matchers.anything
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TodoListSettingsTest {

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testVerifySortingDynamically() {

        // Add multiple tasks dynamically
        val taskList = listOf(
            "Diagnose flaky tests",
            "Perform code surgery",
            "Inject test data",
            "Check system pulse",
            "Prescribe bug fixes"
        )
        taskList.forEach { task ->
            onView(withId(R.id.fab)).perform(click())  // Open add task screen
            onView(withId(R.id.todoText)).perform(typeText(task), closeSoftKeyboard())  // Enter task text
            onView(withId(R.id.submitTodo)).perform(click())  // Submit task
        }

        // Get total number of items dynamically
        val totalItems = getListSize()

        if (totalItems < 2) {
            throw AssertionError("Not enough items to verify sorting")
        }

        // Get all items before sorting
        val itemsBeforeSort = (0 until totalItems).map { getListItemText(it) }

        // Open settings menu
        onView(withContentDescription("More options")).perform(click())
        onView(withText("Settings")).perform(click())

        // Change sorting option to "Sort list by priority"
        onView(withId(R.id.radioSortPriority)).perform(click())

        // Toggle the sorting direction switch dynamically
        onView(withId(R.id.switchAscending)).perform(click())

        // Go back to the main screen
        pressBack()

        // Get all items after sorting
        val itemsAfterSort = (0 until totalItems).map { getListItemText(it) }

        // Assert that sorting actually changed the order
        assertNotEquals("Sorting order did not change!", itemsBeforeSort, itemsAfterSort)
    }

    private fun getListSize(): Int {
        var size = 0
        try {
            while (true) {
                onData(anything()).inAdapterView(withId(R.id.list)).atPosition(size).check(matches(isDisplayed()))
                size++
            }
        } catch (e: Exception) {
            // Stops when no more items are found
        }
        return size
    }

    private fun getListItemText(position: Int): String {
        val itemText = arrayOf("")
        onData(anything()).inAdapterView(withId(R.id.list)).atPosition(position)
            .perform(GetTextAction { text ->
                itemText[0] = text
            })
        return itemText[0]
    }
}
