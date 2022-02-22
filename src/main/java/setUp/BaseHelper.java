package setUp;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restClient.RestClientCall;
import util.GenericResponseDto;

public class BaseHelper {
    /*
    this call provides most useful instances which can be used several times
     */

    public RequestSpecification requestSpecification;
    public RestClientCall restClient = new RestClientCall();
    public GenericResponseDto genericResponse = new GenericResponseDto();
    public Response response;
    public RequestSpecBuilder requestSpecBuilder ;
}
