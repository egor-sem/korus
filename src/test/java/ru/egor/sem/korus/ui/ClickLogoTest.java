package ru.egor.sem.korus.ui;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Feature;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.egor.sem.korus.pageobject.GooglePage;
import ru.egor.sem.korus.pageobject.SearchResultsPage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.Matchers.equalTo;

@Feature("UI")
public class ClickLogoTest {

    @Test(testName = "Go back by clicking logo")
    public void clickLogo() {
        GooglePage googlePage = open("http://google.com", GooglePage.class);
        SearchResultsPage resultsPage = googlePage.searchByClick("азбука");
        resultsPage.getResults().shouldHave(CollectionCondition.sizeGreaterThan(0));
        resultsPage.clickLogo();
    }
}
