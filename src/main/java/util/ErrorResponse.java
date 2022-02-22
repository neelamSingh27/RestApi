package util;

import lombok.Data;

@Data
public class ErrorResponse {
    /*
    this is errr response class which is provide in generic response class
    more types of error response can be added here, as per the requirement
     */
    private String errCode;
    private String errMsg;

    public ErrorResponse(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
   public ErrorResponse(){

   }
}
