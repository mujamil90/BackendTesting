package org.api.tests;

import io.qameta.allure.*;
import org.api.data.PostsData;
import org.api.util.EmailValidation;
import org.testng.annotations.Test;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.api.util.CommonJsonNodes.EMAIL;
import static org.api.util.Endpoints.COMMENTS;
import static org.api.util.Endpoints.POSTS;
import static org.testng.Assert.assertTrue;
/***
 * @author mohammadmuzzamil
 */

@Epic("Smoke Tests")
@Feature("Email Validation Tests")
public class TypiCodeTests extends BaseSetup{

    /***
     * This test case will take all emails from each comment made on a post for user Samantha. All post ids are provided by data provider for user Samantha.
     * All email will be iterated and validated for correct format explained in EmailValidation.java file.
     * @param postId post id address the specific post
     */

    @Test(dataProvider = "getPostIds", dataProviderClass = PostsData.class, priority = 0, description = "Verify correct format of each email address from every comment for specific user.")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Test to validate correct format of email address from each comment.")
    @Story("As a user, I want to validate format of each email address should correct in each comment section.")
    public void testEmailFormatForEachEmailFromEveryCommentPostedByUserSamantha (Integer postId) {
         List<String> emails = given ()
                .get ( POSTS + "/" + postId + COMMENTS) // e.g. https://jsonplaceholder.typicode.com/posts/21/comments
                .then ()
                .statusCode (200)
                .and ()
                .assertThat ()
                .extract()
                .response()
                 .body()
                 .path(EMAIL);
        for ( String email: emails) {
            assertTrue(EmailValidation.patternMatches(email), "Email id '"+ email+ "' is not in correct format.");
        }

    }
}
