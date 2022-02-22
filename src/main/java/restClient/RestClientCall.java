package restClient;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestClientCall {
    /*
    this call contains the generic http method call
    as of now i added post and get , further all can be added here
     */

    public Response post(final RequestSpecification req) {
        return given().spec(req).when().log().all().post().then().extract().response();
    }

    public Response get(final RequestSpecification req) {
        return given().spec(req)

                .when().get().then().extract().response();
    }
}
