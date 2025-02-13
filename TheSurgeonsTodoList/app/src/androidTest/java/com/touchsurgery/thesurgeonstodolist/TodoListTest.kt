package com.touchsurgery.thesurgeonstodolist

import android.util.Log
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.touchsurgery.thesurgeonstodolist.activities.MainActivity
import com.touchsurgery.thesurgeonstodolist.utils.ElapsedTimeIdlingResource
import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.hasToString
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TodoListTest {

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        // Register Idling Resource to wait for UI updates instead of Thread.sleep()
        IdlingRegistry.getInstance().register(ElapsedTimeIdlingResource(2000))
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(ElapsedTimeIdlingResource(2000))
    }

    @Test
    fun addNewTask() {
        // Click Floating Action Button (FAB) to open task input
        onView(withId(R.id.fab)).perform(click())

        // Enter task description
        val taskText = "Prepare surgical instruments"
        onView(withId(R.id.todoText)).perform(typeText(taskText), closeSoftKeyboard())

        // Click "Submit Task" button
        onView(withId(R.id.submitTodo)).perform(click())

        // Wait for list to update
        IdlingRegistry.getInstance().register(ElapsedTimeIdlingResource(2000))

        // Debug log to confirm test execution
        Log.d("TodoListTest", "Checking if '$taskText' is present in the list dynamically")

        // Verify if the new task exists anywhere in the list dynamically
        onData(hasToString(containsString(taskText)))
            .inAdapterView(withId(R.id.list))
            .check(matches(isDisplayed()))
    }
}
