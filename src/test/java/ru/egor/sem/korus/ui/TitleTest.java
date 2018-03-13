package ru.egor.sem.korus.ui;

import io.qameta.allure.Feature;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.egor.sem.korus.pageobject.GooglePage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.Matchers.equalTo;

@Feature("UI")
public class TitleTest {

    @Test
    public void checkTitle() {
        GooglePage googlePage = open("http://google.com", GooglePage.class);
        MatcherAssert.assertThat("Q field has Поиск title", googlePage.getQTitle(), equalTo("Поиск"));
    }

}
