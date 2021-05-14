package org.cordova.quasar.corona.app;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.core.IsNot.not;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> rule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void howAccessDisplayed() {
        onView(withId(R.id.about)).perform(click());
        onView(withId(R.id.como_acessar_btn)).check(matches(isDisplayed()));
    }

    @Test
    public void sponsoredDataAnswerFaq() {
        onView(withId(R.id.questions)).perform(click());
        onView(withId(R.id.sponsored_data_answer)).check(matches(isDisplayed()));
    }

    @Test
    public void wikipediaPage() {
        onView(withId(R.id.wikipedia)).perform(click());
        onView(withId(R.id.web_view)).check(matches(isDisplayed()));
    }

    @Test
    public void googleClassRoomScreen() {
        onView(withId(R.id.classroom)).perform(click());
        onView(withId(R.id.web_view)).check(matches(isDisplayed()));
    }

}