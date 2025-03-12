package com.touchsurgery.thesurgeonstodolist.robots

import android.util.Log
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.touchsurgery.thesurgeonstodolist.R
import com.touchsurgery.thesurgeonstodolist.utils.ElapsedTimeIdlingResource
import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.hasToString

class TodoListRobot {

    fun openAddTaskScreen(): TodoListRobot {
        onView(withId(R.id.fab)).perform(click())
        return this
    }

    fun enterTaskDescription(taskText: String): TodoListRobot {
        onView(withId(R.id.todoText)).perform(typeText(taskText), closeSoftKeyboard())
        return this
    }

    fun submitTask(): TodoListRobot {
        onView(withId(R.id.submitTodo)).perform(click())
        return this
    }

    fun waitForListUpdate(): TodoListRobot {
        IdlingRegistry.getInstance().register(ElapsedTimeIdlingResource(2000))
        return this
    }

    fun verifyTaskExists(taskText: String): TodoListRobot {
        Log.d("TodoListRobot", "Checking if '$taskText' is present in the list dynamically")
        onData(hasToString(containsString(taskText)))
            .inAdapterView(withId(R.id.list))
            .check(matches(isDisplayed()))
        return this
    }
}
