package in.reqres.api.users;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;
import in.reqres.api.UsersPojo;
import in.reqres.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static in.reqres.api.UsersPojo.getRandomString;
import static io.restassured.RestAssured.given;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by Ankita
 */
public class PostUsers  extends TestBase {

    String name = "Mary" + getRandomString(2);
    String job = "leader" + getRandomString(2);
    String email = "eve.holt@reqres.in";
    String password = "abc" +getRandomString(3);

    @Test
    public void createNewUser(){
        UsersPojo usersPojo = new UsersPojo();
        usersPojo.setName(name);
        usersPojo.setJob(job);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(usersPojo)
                .post("/users");
        response.then().statusCode(201)
                .log().body();


    }

    @Test
    public void registerUserSuccessfully(){
        UsersPojo usersPojo = new UsersPojo();
        usersPojo.setEmail("eve.holt@reqres.in");
        usersPojo.setPassword(password);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(usersPojo)
                .post("/register");
        response.then().statusCode(200)
                .log().body();


    }

    @Test
    public void unsuccessfullUserRegistration(){
        UsersPojo usersPojo = new UsersPojo();
        usersPojo.setEmail("eve.holt@reqres.in");


        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(usersPojo)
                .post("/register");
        response.then().statusCode(400)
                .log().body();

    }

    @Test
    public void loginSuccessfully(){
        UsersPojo usersPojo = new UsersPojo();
        usersPojo.setEmail(email = "eve.holt@reqres.in");
        usersPojo.setPassword(password);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(usersPojo)
                .post("/login");
        response.then().statusCode(200)
                .log().body();

    }

    @Test
    public void unsuccessfullUserLogin(){
        UsersPojo usersPojo = new UsersPojo();
        usersPojo.setEmail(email);


        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(usersPojo)
                .post("/login");
        response.then().statusCode(400)
                .log().body();

    }
}
