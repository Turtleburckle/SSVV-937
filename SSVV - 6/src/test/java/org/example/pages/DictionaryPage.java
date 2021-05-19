package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.Collections;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("https://www2.hm.com/ro_ro/index.html")
public class DictionaryPage extends PageObject {

    @FindBy(name="q")
    private WebElementFacade searchTerms;

    @FindBy(className="menu__search_submit")
    WebElementFacade lookupButton;

    @FindBy(xpath = "//*[@id=\"menu-links\"]/li[2]/label")
    WebElementFacade filterButton;


    public void filterButtonDown(){
        filterButton.click();
    }

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.className("filter-pagination"));
        return Collections.singletonList(definitionList.getText());
    }
}