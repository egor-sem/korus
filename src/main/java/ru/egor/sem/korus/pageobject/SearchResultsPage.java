package ru.egor.sem.korus.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class SearchResultsPage {
    @FindBy(css = "#ires .rc .r a")
    private ElementsCollection results;

    @FindBy(id = "logocont")
    private SelenideElement logo;

    public ElementsCollection getResults() {
        return results;
    }

    @Step("Click on logo")
    public GooglePage clickLogo() {
        logo.click();
        results.get(0).should(Condition.disappears);
        return page(GooglePage.class);
    }
}
