package apihelper;

import constants.BaseUrl;
import constants.Params;
import constants.RestEndPoints;
import dto.DataResponeDto;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import setUp.BaseHelper;
import util.GenericResponseDto;


public class DataApiHelper extends BaseHelper {
    private String baseURI = BaseUrl.BASE_URL;
    private static Logger log = Logger.getLogger(DataApiHelper.class);

/*
this api call method will take two params to get the response
response is then converted to the generic response so that travesal of response json
become easy
this method returns the generic response
 */


public GenericResponseDto<DataResponeDto> getUsaData(String param1, String param2){
  RequestSpecBuilder  requestSpecBuilder = new RequestSpecBuilder();
    requestSpecBuilder.setBaseUri(BaseUrl.BASE_URL);
    requestSpecBuilder.setBasePath(RestEndPoints.DATA_USA);
    requestSpecBuilder.addQueryParam(Params.DRILL_DOWN, param1);
    requestSpecBuilder.addQueryParam(Params.MEASURES,param2);
    requestSpecBuilder.setContentType(ContentType.JSON);
    requestSpecification = requestSpecBuilder.build();

    log.info("\n\ngetUsaData----->" + requestSpecBuilder.log(LogDetail.ALL));
    Response response = restClient.get(requestSpecification);
log.info("response is ------>"+response.toString());

return genericResponse.toClassRest(response, DataResponeDto.class);
}



}
