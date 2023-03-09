package com.ghedamsisabri.ui_testing_for_beginner.source

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.ghedamsisabri.ui_testing_for_beginner.Helper.*
import com.ghedamsisabri.ui_testing_for_beginner.MainActivity
import com.ghedamsisabri.ui_testing_for_beginner.R
import org.hamcrest.Matcher
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule


@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {

    @get:Rule var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun checkSecondPageLabelAndButton() {
        NextBtn.tap()
        secondPageActivity.isViewDisplayed()

        isTextOnScreen("SecondaryActivity")

        // assert 1
        Assert.assertEquals("SecondaryActivity", secondPageActivity.getText(5))

        // assert 2
        Assert.assertTrue(backButton.isViewDisplayed())
//        Assert.assertTrue(onView(backButton).check(matches(isDisplayed())))
    }

    companion object{
        val NextBtn: Matcher<View> by lazy { withId(R.id.button_next_activity) }
        val secondPageActivity: Matcher<View> by lazy { withId(R.id.activity_secondary_title) }
        val backButton: Matcher<View> by lazy { withId(R.id.button_back) }
    }
}