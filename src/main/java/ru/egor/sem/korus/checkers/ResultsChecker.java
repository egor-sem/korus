package ru.egor.sem.korus.checkers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import ru.egor.sem.korus.utils.ResourceReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class ResultsChecker {

    @Step("Compare results")
    public static void compareResults(ElementsCollection actualResult, String resultsName) {
        List<String> expectedLinks = ResourceReader.readLines("searchresults/" + resultsName);
        Map<String, String> actualMap = new HashMap<>();
        for (SelenideElement link : actualResult) {
            actualMap.put(link.attr("href"), link.text());
        }
        MatcherAssert.assertThat("Results size", actualResult.size(), equalTo(expectedLinks.size()));

        StringBuilder notFoundResults = new StringBuilder("");
        for (String expectedLink : expectedLinks) {
            String[] link = expectedLink.split(";");
            String actualTitle = actualMap.get(link[0]);

            if (actualTitle == null || !actualTitle.equals(link[1])) {
                notFoundResults.append(expectedLink);
            }
            MatcherAssert.assertThat("Not found results should be empty", notFoundResults.toString(), equalTo(""));
        }
    }

}
