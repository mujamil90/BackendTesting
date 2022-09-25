package data;

import io.restassured.response.Response;
import static com.jayway.restassured.path.json.JsonPath.from;
import static io.restassured.RestAssured.given;
import static org.api.util.CommonJsonNodes.ID;
import static org.api.util.CommonJsonNodes.USER_NAME;
import static org.api.util.Endpoints.BASE_URL;
import static org.api.util.Endpoints.USERS;

/***
 * @author mohammadmuzzamil
 */
public class UserData {

    /***
     *  we are capturing common response for a given endpoint so we can reuse it to get data for userId and PostIds.
     *
     *
     * @param endpoint is used to access specific resource for typicode apis.
     * @return response for provide @endpoint
     */
    public static Response getResponseForEndPoint(String endpoint){
       return given ()
                .get (BASE_URL + endpoint)
                .then ()
                .statusCode (200)
                .and ()
                .assertThat ()
                .extract()
                .response();
    }

    /***
     * This method will return user-Id for provided user as method parameter. Its uses JsonPath to check user in Json response and
     *  return user id.
     * @param user is name of user for which it searchs for user id.
     * @return user id of @user
     */
    public static String getIdForUser(String user){

        String response = getResponseForEndPoint(USERS).asString(); //e.g. https://jsonplaceholder.typicode.com/users
        return from(response).getList("findAll{it."+ USER_NAME +"=='"+user+"' }."+ ID).get(0).toString();
    }


}
