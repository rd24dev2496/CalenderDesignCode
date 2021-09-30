package com.example.calaenderdesign;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)

public class FabActivityTest {
    @Rule
    public ActivityTestRule<FabActivity> mActivityTestRule = new ActivityTestRule<>(FabActivity.class);

    @Test
    public void onEditText() {
        ActivityScenario.launch(FabActivity.class);
        onView(withText(startsWith("ABC"))).perform(click());
        onView(withId(R.id.et_task)).check(matches(isDisplayed()));
    }
    @Test
    public void submitButton() {
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.submit_btn)).perform(click());

    }
  /*  @Test
    public void onEditTextNotBeEmpty() {
        ActivityScenario.launch(FabActivity.class);
       onView(withId(R.id.et_task)).check(matches(hasErrorText("Rishabh")));

    }*/

}