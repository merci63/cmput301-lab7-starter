package com.example.androiduitesting;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Intent;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class showActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> scenario = new ActivityScenarioRule<MainActivity>(MainActivity.class);
    @Test
    public void testActivitySwitch(){
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(typeText("Edmonton"));
        onView(withId(R.id.button_confirm)).perform(click());
        onView(withText("Edmonton")).perform(click());

        onView(withId(R.id.city_name)).check(matches(isDisplayed()));
        onView(withId(R.id.back_btn)).check(matches(isDisplayed()));
    }
    @Test
    public void testCityName(){
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(typeText("Edmonton"));
        onView(withId(R.id.button_confirm)).perform(click());
        onView(withText("Edmonton")).perform(click());
        closeSoftKeyboard();
        onView(withId(R.id.city_name)).check(matches(isDisplayed()));
    }
    @Test
    public void testBackButton(){
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(typeText("Edmonton"));
        onView(withId(R.id.button_confirm)).perform(click());
        onView(withText("Edmonton")).perform(click());

        onView(withId(R.id.back_btn)).perform(click());
        onView(withId(R.id.city_list)).check(matches(isDisplayed()));
    }
}
