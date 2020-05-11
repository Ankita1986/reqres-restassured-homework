package in.reqres.api.users;

import in.reqres.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by Ankita
 */
public class DeleteUsers extends TestBase {

    @Test
    public void deleteUserById() {


        Response response = given()
                .when()
                .delete("/users/2");
        response.then().statusCode(204);
    }
}
