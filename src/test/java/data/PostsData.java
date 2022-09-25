package data;

import org.testng.annotations.DataProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static data.UserData.getIdForUser;
import static data.UserData.getResponseForEndPoint;
import static org.api.util.CommonJsonNodes.ID;
import static org.api.util.CommonJsonNodes.USER_ID;
import static org.api.util.Endpoints.POSTS;

/***
 * @author mohammadmuzzamil
 */
public class PostsData {

    private String SAMANTHA = "Samantha";

    /***
     *
     * @return return List of Ids of post created by specific user
     */
    public List<Integer []> getAllPostIds(){
        return getResponseForEndPoint(POSTS +"?"+ USER_ID +"="+ getIdForUser(SAMANTHA))// e.g. https://jsonplaceholder.typicode.com/posts?userId=1
                .body()
                .path(ID);
    }


    /***
     * Provided All Post ids to test cases to crawl all comments in each posts for specific user.
     * @return Iterator of object array contains Post ids.
     */
    @DataProvider(name = "getPostIds")
    public Iterator<Object []> getPostIds () {
        List<Object []> postIds = new ArrayList<>();
        List<Integer []> Ids = getAllPostIds();
        for ( Object Id: Ids) {
            postIds.add (new Object [] { Id});
        }
        return postIds.iterator ();
    }
}
