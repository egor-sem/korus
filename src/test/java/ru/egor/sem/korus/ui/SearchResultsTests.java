package ru.egor.sem.korus.ui;

import com.codeborne.selenide.*;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.egor.sem.korus.checkers.ResultsChecker;
import ru.egor.sem.korus.pageobject.GooglePage;
import ru.egor.sem.korus.pageobject.SearchResultsPage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.open;

@Feature("UI")
public class SearchResultsTests {

    @BeforeSuite
    public void config() {
        Configuration.browser = "firefox";
        Configuration.holdBrowserOpen = true;
        System.setProperty("selenide.browser", "firefox");
    }

    @Test()
    public void barcaSearch() {
        GooglePage googlePage = open("http://google.com", GooglePage.class);
        SearchResultsPage resultsPage = googlePage.searchByEnter("FC Barcelona");
        ElementsCollection results = resultsPage.getResults().shouldHave(sizeGreaterThan(0));
        for (SelenideElement element : results) {
            System.out.println(element.attr("href") + ";" + element.text());
        }
        ResultsChecker.compareResults(results, "barca.txt");
    }

    @Test
    public void landauSearch() {
        GooglePage googlePage = open("http://google.com", GooglePage.class);
        SearchResultsPage resultsPage = googlePage.searchByEnter("ландау лев давидович");
        ElementsCollection results = resultsPage.getResults().shouldHave(sizeGreaterThan(0));
        for (SelenideElement element : results) {
            System.out.println(element.attr("href") + ";" + element.text());
        }
        ResultsChecker.compareResults(results, "dau.txt");
    }

    @Test
    public void landauSearchButtonClick() {
        GooglePage googlePage = open("http://google.com", GooglePage.class);
        SearchResultsPage resultsPage = googlePage.searchByClick("ландау лев давидович");
        ElementsCollection results = resultsPage.getResults().shouldHave(sizeGreaterThan(0));
        ResultsChecker.compareResults(results, "dau.txt");
    }

    @AfterSuite
    public void close() {
        WebDriverRunner.getWebDriver().close();
        Selenide.close();
    }
}
