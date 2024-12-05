package com.example.android.testing.espresso.BasicSample

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @Test
    fun validateTextView() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.textToBeChanged))
            .check(matches(withText(R.string.hello_world)))
    }

    @Test
    fun enter123AndChangeText() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.editTextUserInput))
            .perform(replaceText("123"))
        onView(withId(R.id.changeTextBt))
            .perform(click())
        onView(withId(R.id.textToBeChanged))
            .check(matches(withText("123")))
    }

    @Test
    fun enter123AndOpenActivityAndChangeText() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.editTextUserInput))
            .perform(replaceText("123"))
        onView(withId(R.id.activityChangeTextBtn))
            .perform(click())
        onView(withId(R.id.show_text_view))
            .check(matches(withText("123")))
    }

    @Test
    fun noTextAndChangeText() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.changeTextBt))
            .perform(click())
        onView(withId(R.id.textToBeChanged))
            .check(matches(withText("")))
    }

    @Test
    fun noTextAndOpenActivityAndChangeText() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.activityChangeTextBtn))
            .perform(click())
        onView(withId(R.id.show_text_view))
            .check(matches(withText("")))
    }

    @Test
    fun enterAbcdefAndChangeText() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.editTextUserInput))
            .perform(replaceText("abcdef"))
        onView(withId(R.id.changeTextBt))
            .perform(click())
        onView(withId(R.id.textToBeChanged))
            .check(matches(withText("abcdef")))
    }

    @Test
    fun enterAbcdefAndOpenActivityAndChangeText() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.editTextUserInput))
            .perform(replaceText("abcdef"))
        onView(withId(R.id.activityChangeTextBtn))
            .perform(click())
        onView(withId(R.id.show_text_view))
            .check(matches(withText("abcdef")))
    }

    @Test
    fun validateCorrectStringsInShowTextActivity() {
        val intent = ShowTextActivity.newStartIntent(ApplicationProvider.getApplicationContext(), "Test String")
        ActivityScenario.launch<ShowTextActivity>(intent)
        onView(withId(R.id.show_text_view))
            .check(matches(withText("Test String")))
    }
}
