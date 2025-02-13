package com.touchsurgery.thesurgeonstodolist.utils

import androidx.test.espresso.IdlingResource

class ElapsedTimeIdlingResource(private val waitingTime: Long) : IdlingResource {
    private val startTime = System.currentTimeMillis()
    private var resourceCallback: IdlingResource.ResourceCallback? = null

    override fun getName(): String = ElapsedTimeIdlingResource::class.java.name

    override fun isIdleNow(): Boolean {
        val elapsed = System.currentTimeMillis() - startTime
        val idle = elapsed >= waitingTime
        if (idle) resourceCallback?.onTransitionToIdle()
        return idle
    }

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback) {
        this.resourceCallback = callback
    }
}
