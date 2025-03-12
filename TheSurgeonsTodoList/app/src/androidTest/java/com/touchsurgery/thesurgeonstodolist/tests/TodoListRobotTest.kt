package com.touchsurgery.thesurgeonstodolist.tests

import androidx.test.espresso.IdlingRegistry
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.touchsurgery.thesurgeonstodolist.activities.MainActivity
import com.touchsurgery.thesurgeonstodolist.robots.TodoListRobot
import com.touchsurgery.thesurgeonstodolist.utils.ElapsedTimeIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TodoListRobotTest {  // ✅ New Test Case Using Robot Pattern

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(ElapsedTimeIdlingResource(2000))
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(ElapsedTimeIdlingResource(2000))
    }

    @Test
    fun addNewTaskUsingRobotPattern() {
        val todoList = TodoListRobot()

        todoList.openAddTaskScreen()
            .enterTaskDescription("Prepare surgical instruments")
            .submitTask()
            .waitForListUpdate()
            .verifyTaskExists("Prepare surgical instruments")
    }
}
