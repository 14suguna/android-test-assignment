package com.touchsurgery.thesurgeonstodolist.utils

import android.view.View
import android.widget.SeekBar
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import org.hamcrest.Matcher

class SeekBarAction(private val progress: Int) : ViewAction {

    override fun getConstraints(): Matcher<View> {
        return isAssignableFrom(SeekBar::class.java)
    }

    override fun getDescription(): String {
        return "Set SeekBar progress to: $progress"
    }

    override fun perform(uiController: UiController, view: View) {
        val seekBar = view as SeekBar
        seekBar.progress = progress
    }
}
