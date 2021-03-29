package com.tests;


import com.api.endpoints.Covid19Data;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.filter.log.ErrorLoggingFilter;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static com.interfaces.constants.RAPID_API_HOST;
import static com.interfaces.constants.RAPID_API_KEY;
import static com.util.DataItem.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class covid19DataTest {
    static RequestSpecBuilder requestSpecBuilder;
    static JsonPath response;
    static ResponseSpecification checkStatusCode = new ResponseSpecBuilder().
                                                       expectStatusCode(200).
                                                       build();
    static String param_country = "Italy";
    

    @Test
    public void testGetLatestForCountryByUsingCode() {
        response = Covid19Data.getLatestCountryDataByCode(reqSpec(), "it")
                                .then()
                                .spec(checkStatusCode)
                                .extract().jsonPath();
        Assert.assertThat(String.valueOf(response.get("country").toString()), CoreMatchers.containsString(param_country));
        Assert.assertThat(String.valueOf(response.get("code").toString()), CoreMatchers.containsString("IT"));
    }
    @Test
    public void testGetLatestForCountryByUsingName() {

        response = Covid19Data.getLatestCountryDataByName(reqSpec(), param_country)
                            .then()
                            .spec(checkStatusCode)
                            .extract().jsonPath();

        int critical =Integer.parseInt(response.get("critical").toString().replaceAll("\\[", "").replaceAll("\\]",""));
        int confirmed =Integer.parseInt(response.get("confirmed").toString().replaceAll("\\[", "").replaceAll("\\]",""));
        int recovered =Integer.parseInt(response.get("recovered").toString().replaceAll("\\[", "").replaceAll("\\]",""));
        int deaths =Integer.parseInt(response.get("deaths").toString().replaceAll("\\[", "").replaceAll("\\]",""));

        Assert.assertThat(String.valueOf(response.get("country").toString()), CoreMatchers.containsString(param_country));
        Assert.assertThat(String.valueOf(response.get("code").toString()), CoreMatchers.containsString("IT"));
        Assert.assertThat(critical, is(greaterThan(0)));
        Assert.assertThat(confirmed, is(greaterThan(0)));
        Assert.assertThat(recovered, is(greaterThan(0)));
        Assert.assertThat(deaths, is(greaterThan(0)));
    }

    private static RequestSpecification reqSpec(){
        requestSpecBuilder = new    RequestSpecBuilder()
                                    .addHeader(RAPID_API_KEY, AUTH_KEY)
                                    .addHeader(RAPID_API_HOST, API_HOST)
                                    .setBaseUri(RAPID_API_BASE_URI)
                                    .addFilter(new ErrorLoggingFilter())
                                    .addFilter(new RequestLoggingFilter())
                                    .addFilter(new ResponseLoggingFilter());
        return requestSpecBuilder.build();
    }
}
