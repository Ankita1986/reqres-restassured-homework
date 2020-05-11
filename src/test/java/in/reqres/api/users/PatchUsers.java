package in.reqres.api.users;

import in.reqres.api.UsersPojo;
import in.reqres.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static in.reqres.api.UsersPojo.getRandomString;
import static io.restassured.RestAssured.given;

/**
 * Created by Ankita
 */
public class PatchUsers extends TestBase {

    String name = "Mary" + getRandomString(2);
    String job = "zion resident" + getRandomString(2);

    @Test
    public void updateUserByJobOnly(){
        UsersPojo usersPojo = new UsersPojo();
        usersPojo.setName(name);
        usersPojo.setJob(job);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(usersPojo)
                .patch("/users/4");
        response.then().statusCode(200)
                .log().body();


    }
}
