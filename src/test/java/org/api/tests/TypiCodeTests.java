package org.api.tests;

import data.PostsData;
import org.api.util.EmailValidation;
import org.testng.annotations.Test;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;
/***
 * @author mohammadmuzzamil
 */
public class TypiCodeTests {

    /***
     * This test case will take all emails from each comment made on a post for user Samantha. All post ids are provided by data provider for user Samantha.
     * All email will be iterated and validated for correct format explained in EmailValidation.java file.
     * @param postId post id address the specific post
     */

    @Test(dataProvider = "getPostIds", dataProviderClass = PostsData.class)
    public void testGetPosts (Integer postId) {
         List<String> emails = given ()
                .get ("https://jsonplaceholder.typicode.com/posts/"+ postId +"/comments" )
                .then ()
                .statusCode (200)
                .and ()
                .assertThat ()
                .extract()
                .response()
                 .body()
                 .path("email");
        for ( String email: emails) {
            assertTrue(EmailValidation.patternMatches(email), "Email id '"+ email+ "' is not in correct format.");
        }

    }
}
