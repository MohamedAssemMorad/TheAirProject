package com.example.theair

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.theair.core.utils.NetworkUtil
import com.example.theair.data.model.MovieCreditsResponse
import com.example.theair.data.model.MovieResultsResponse
import com.example.theair.presentation.viewmodel.MovieCreditsViewModel

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.theair", appContext.packageName)
    }

    @Test
    fun testNetworkConnectivity_isNotConnect() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals(!NetworkUtil.isNetworkAvailable(appContext), false)
    }

    @Test
    fun testNetworkConnectivity_isConnect() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals(NetworkUtil.isNetworkAvailable(appContext), true)
    }

}