package org.api.tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import static org.api.util.CommonJsonNodes.ACCEPT;
import static org.api.util.CommonJsonNodes.CONTENT_TYPE;
import static org.api.util.Endpoints.BASE_URL;
import static org.hamcrest.Matchers.lessThan;

/***
 * @author mohammadmuzzamil
 *
 *
 * This class do base set up like set up base URL, common headers, Common assertion, common Request and response
 * specifications and logging (we do not need to use 'log().all()' in test cases.
 */
public class BaseSetup {

    @BeforeClass
    public void setup () {

        RequestSpecification requestSpecification = new RequestSpecBuilder ()
            .setBaseUri (BASE_URL)
            .addHeader (CONTENT_TYPE, "application/json")
            .addHeader (ACCEPT, "application/json")
            .addFilter (new RequestLoggingFilter ())
            .addFilter (new ResponseLoggingFilter ())
            .build ();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder ().expectResponseTime (lessThan (20000L))
            .build ();

        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;

    }
}