package tk.hongkailiu.test.mongodb;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.hamcrest.Matchers;

/**
 * Created by ehongka on 4/6/16.
 */
public class MongoUtil {

    private static final String REPL_SET_GET_STATUS_PATH = "/replSetGetStatus";

    public static void checkReplicaSet(String mongoIP, int mongoHttpPort, String hostname,
        int mongoPort) {

        String base_uri = Params.HTTP + mongoIP;
        String expected_name = hostname + Params.COLON + mongoPort;
        RestAssured.given().baseUri(base_uri).port(mongoHttpPort).
            get(REPL_SET_GET_STATUS_PATH).then().assertThat().statusCode(200).contentType(
            ContentType.JSON)
            //.log().body()
            .body("members", Matchers
                .hasItem(Matchers.hasEntry(Matchers.is("name"), Matchers.is(expected_name))));
    }

    public static void main(String[] args) {
        MongoUtil.checkReplicaSet("142.133.111.170", 28017, "my-mongo", 27017);
        //MongoUtil.create10Persons("142.133.111.170", 27017);
    }
}
