package com.example.coachingapp;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import androidx.test.espresso.Espresso;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class AboutUsTest {

    @Rule
    public ActivityTestRule<AboutUs> activityRule = new ActivityTestRule<>(AboutUs.class);

    @Test
    public void activityLaunchesSuccessfully() {
        ActivityScenario<AboutUs> scenario = ActivityScenario.launch(AboutUs.class);

        Espresso.onView(withId(R.id.activity_about_us))
                .check(matches(isDisplayed()));
    }
}
