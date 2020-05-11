package in.reqres.api.users;

import in.reqres.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Ankita
 */
public class GetUsers  extends TestBase {

    @Test
    public void getUsersList(){

       Response response = given()
                .param("page", 2)
                .when()
                .get("/list");
                response.then().statusCode(200)
                        .log().body()
                        .body("data.size()",equalTo(6));

    }

    @Test
    public void getSingleUser(){
        Response response = given()
                .when()
                .get("/users/2");
        response.then().statusCode(200)
                .log().body()
                .body("data.first_name", equalTo("Janet"));

    }
    @Test
    public void singleUserNotFound(){
        Response response = given()
                .when()
                .get("/users/23");
        response.then().statusCode(404);




    }


}
