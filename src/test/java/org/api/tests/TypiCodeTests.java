package org.api.tests;

import data.PostsData;
import org.api.util.EmailValidation;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static io.restassured.RestAssured.given;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.testng.Assert.assertTrue;

public class TypiCodeTests {

    String userId ;

    @Test
    public void getBookingTest () {
        String response =given ()
                .get ("https://jsonplaceholder.typicode.com/users" )
                .then ()
                .statusCode (200)
                .and ()
                .assertThat ()
                .log()
                .all()
                .extract()
                .response().asString();
       userId = from(response).getList("findAll{it.username=='Samantha' }.id").get(0).toString();

    }


    @Test
    public void getPostsFromExtractedUser () {
        given ()
                .get ("https://jsonplaceholder.typicode.com/posts?userId=" + userId)
                .then ()
                .statusCode (200)
                .and ()
                .assertThat ()
                .log()
                .all()
                .extract()
                .response().body().path("id");


    }


    @Test
    public void testGetPosts () {
       String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
         List<String> emails = given ()
                .get ("https://jsonplaceholder.typicode.com/posts/21/comments" )
                .then ()
                .statusCode (200)
                .and ()
                .assertThat ()
                .extract()
                .response().body().path("email");
        for ( String email: emails) {
            assertTrue( EmailValidation.patternMatches(email, regexPattern), "Email id '"+ email+ "' is not in correct format.");
        }

    }


}
