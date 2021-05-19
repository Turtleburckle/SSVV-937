package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import org.example.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;


    @Test
    public void searching_by_keyword_blouse_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("blouse");
        anna.should_see_definition("1 articole");
    }

    @Test
    public void searching_by_keyword_invalidBlouse_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("blouse");
        anna.should_not_see_definition("2 articole");
    }

    @Test
    public void searching_by_keyword_jeans_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("jeans");
        anna.selectFilter();
        anna.should_see_definition("389 articole");
    }

    @Test
    public void searching_by_keyword_jeansInvalid_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("jeans");
        anna.selectFilter();
        anna.should_not_see_definition("644 articole");
    }

    @Pending @Test
    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
    }
} 