package util;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class GenericResponseDto<T> {
    /*
    this call helps to wrap the response in generic response
    this provides data, error and status code for every response
    it makes traversal easy
     */
    private T data;
    private ErrorResponse error;
    private int statusCode;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public synchronized GenericResponseDto<T> toClassRest(Response response, Class<T> class1) {
        data = null;
        error = null;
        ErrorResponse errorResponse = new ErrorResponse();
        if (null != response.jsonPath().get("error")) {
            errorResponse.setErrMsg((String) ((Map<Object, Object>) response.jsonPath().get("error")).get("errorMessage"));
            errorResponse.setErrCode((String) ((Map<Object, Object>) response.jsonPath().get("error")).get("errorCode"));
        } else
            this.data = response.as(class1);
        this.error = errorResponse;
        statusCode = response.getStatusCode();
        return this;
    }


}
