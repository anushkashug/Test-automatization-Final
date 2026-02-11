package com.Ana.framework.api;

import io.restassured.http.ContentType;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public final class ApiUserFactory {
    private ApiUserFactory() {}

    public static com.Ana.framework.api.ApiTestUser createFreshUser() {
        String name = "Test User";
        String email = "api_user_" + UUID.randomUUID() + "@example.com";
        String password = "Pass123!";

        // API 11: POST /api/createAccount (201: User created!)
        // Params required by API list: name, email, password, title, birth_date, birth_month, birth_year,
        // firstname, lastname, company, address1, address2, country, zipcode, state, city, mobile_number
        // :contentReference[oaicite:2]{index=2}
        given()
                .contentType(ContentType.URLENC)
                .formParam("name", name)
                .formParam("email", email)
                .formParam("password", password)
                .formParam("title", "Mr")
                .formParam("birth_date", "10")
                .formParam("birth_month", "May")
                .formParam("birth_year", "1999")
                .formParam("firstname", "Test")
                .formParam("lastname", "User")
                .formParam("company", "Company")
                .formParam("address1", "Tbilisi")
                .formParam("address2", "Saburtalo")
                .formParam("country", "Canada")
                .formParam("zipcode", "0101")
                .formParam("state", "State")
                .formParam("city", "City")
                .formParam("mobile_number", "555123456")
                .when()
                .post("/api/createAccount")
                .then()
                .statusCode(201);

        return new com.Ana.framework.api.ApiTestUser(name, email, password);
    }
}
