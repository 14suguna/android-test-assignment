package com.touchsurgery.thesurgeonstodolist.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import com.touchsurgery.thesurgeonstodolist.R
import com.touchsurgery.thesurgeonstodolist.utils.SeekBarAction

class TodoListPriorityRobot {

    fun addTask(taskName: String, priority: Int): TodoListPriorityRobot {
        onView(withId(R.id.fab)).perform(click()) // Open input form
        onView(withId(R.id.todoText)).perform(typeText(taskName), closeSoftKeyboard()) // Enter task description
        onView(withId(R.id.seekBar)).perform(SeekBarAction(priority)) // Set SeekBar priority
        onView(withId(R.id.submitTodo)).perform(click()) // Submit task
        return this
    }
}
