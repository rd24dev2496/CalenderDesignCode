package com.example.calaenderdesign;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void OnclickSpinner() {
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.spinner)).perform(click());

    }

    @Test
    public  void checkTextView()
    {
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.month_name)).check(matches(withText("September")));
    }

    @Test
    public void floatingButton() {
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.submit)).perform(click());

    }
}