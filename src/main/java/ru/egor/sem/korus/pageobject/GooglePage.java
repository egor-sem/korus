package ru.egor.sem.korus.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class GooglePage {
    @FindBy(name = "q")
    private SelenideElement q;

    @FindBy(name = "bntK")
    private SelenideElement button;

    @FindBy(css = ".sbsb_g span:nth-child(1) > span > input")
    private SelenideElement buttonInList;


    @Step("Search pressing Enter")
    public SearchResultsPage searchByEnter(String text) {
        q.setValue(text).pressEnter();
        return page(SearchResultsPage.class);
    }

    @Step("Search clicking button")
    public SearchResultsPage searchByClick(String text) {
        q.setValue(text);
        buttonInList.click();
        return page(SearchResultsPage.class);
    }

    @Step("Hover mouse to input field")
    public void hoverToQ() {
        q.hover();
    }

    @Step("Get title of input field")
    public String getQTitle() {
        return q.attr("title");
    }
}
