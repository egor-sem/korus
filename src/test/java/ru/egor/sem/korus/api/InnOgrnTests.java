package ru.egor.sem.korus.api;

import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.Matchers.equalTo;

@Feature("API")
public class InnOgrnTests {

    @Test(testName = "INN request")
    public void innTest() throws URISyntaxException {
        URI url = new URI("http://lkk.esphere.ru/informator/api/v2/task/search");
        given().
                param("innOgrn", "7703228474").
        when()
                .get(url).
        then().
                statusCode(200).
                body("data.свЮЛ.инн", equalTo("7703228474")).
                body("data.свЮЛ.огрн", equalTo("1037739437966")).
                body("data.свЮЛ.свНаимЮЛ.наимЮЛСокр", equalTo("ООО \"ТАНК-К\"")).
                body(matchesJsonSchemaInClasspath("json-schema.json"));
    }

    @Test(testName = "OGRN request")
    public void ogrnTest() throws URISyntaxException {
        URI url = new URI("http://lkk.esphere.ru/informator/api/v2/task/search");
        given().
                param("innOgrn", "1037739437966").
        when()
                .get(url).
        then().
                statusCode(200).
                body("data.свЮЛ.инн", equalTo("7703228474")).
                body("data.свЮЛ.огрн", equalTo("1037739437966")).
                body("data.свЮЛ.свНаимЮЛ.наимЮЛСокр", equalTo("ООО \"ТАНК-К\"")).
                body(matchesJsonSchemaInClasspath("json-schema.json"));
    }
}
