package in.reqres.api.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created by Ankita
 */
public class TestBase {




    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";


    }
}
