package com.api.endpoints;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.enums.requestEndPoints.*;
import static com.jayway.restassured.RestAssured.given;



public class Covid19Data {


    public static Response getDailyReportAllCountries(RequestSpecification requestSpecification, String param_date) {
        return  given()
                .spec(requestSpecification)
                .param("date", param_date)
                .get(REPORT_COUNTRY.toString());
    }

    public static Response getDailyReportByCountryName(RequestSpecification requestSpecification, String param_date, String country_name) {
        return  given()
                .spec(requestSpecification)
                .param("date", param_date)
                .param("name", country_name)
                .get(REPORT_COUNTRY_NAME.toString());
    }

    public static Response getDailyReportByCountryCode(RequestSpecification requestSpecification, String param_date, String country_code) {
        return  given()
                .spec(requestSpecification)
                .param("code", country_code)
                .get(REPORT_COUNTRY_CODE.toString());
    }

    public static Response getLatestCountryDataByCode(RequestSpecification requestSpecification, String country_code) {
        return  given()
                .spec(requestSpecification)
                .param("code", country_code)
                .get(COUNTRY_CODE.toString());
    }

    public static Response getLatestCountryDataByName(RequestSpecification requestSpecification, String country_name) {
        return  given()
                .spec(requestSpecification)
                .param("name", country_name)
                .get(COUNTRY_NAME.toString());
    }


}
