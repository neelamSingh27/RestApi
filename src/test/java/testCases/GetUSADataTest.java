package testCases;

import apihelper.DataApiHelper;
import constants.ParamValues;
import dto.DataResponeDto;
import dto.Datum;
import org.testng.annotations.Test;
import response.DataResponsePojo;
import setUp.TestSetUp;
import util.GenericResponseDto;

import java.util.ArrayList;


public class GetUSADataTest extends TestSetUp {
    public DataApiHelper apiHelper = new DataApiHelper();
    public GenericResponseDto<DataResponeDto> response;
    public int year;

    @Test(description = "this is to check with two query param - nation and population")
    public void getDataWithNationAndPopulation() {
        //calling the api
        response = apiHelper.getUsaData(ParamValues.nation, ParamValues.population);

        // asserting only param part as discussed in the interview process, rest schema validation
        // takes place once the conversion of response is done by generic response dto
        //checking the param as per request
        softAssert.assertEquals(response.getStatusCode(),200,"check the status code on correct param");
        ArrayList<Datum> arrayList = response.getData().getUsaData().getData();
        for (int i = 0; i < arrayList.size(); i++) {
            softAssert.assertEquals(arrayList.get(i).getNation(), ParamValues.nationValue, "checking the value of nation");
            softAssert.assertNotNull(arrayList.get(i).getPopulation(), "checking the value of population is not null");
        }
        //to check the failures of soft assert use assert all in the end
        softAssert.assertAll();
    }

    @Test(description = "this is to check with two query param - id nation and year")
    public void getDataWithIdNationNYear(){
        //calling the api
        response = apiHelper.getUsaData(ParamValues.id_nation, ParamValues.year);

        //checking the param as per request
        softAssert.assertEquals(response.getStatusCode(),200,"check the status code on correct param");
        ArrayList<Datum> arrayList = response.getData().getUsaData().getData();
        for (int i = 0; i < arrayList.size(); i++) {
            softAssert.assertEquals(arrayList.get(i).getIDNation(), ParamValues.idNationValue, "checking the value of id nation");
            year=Integer.parseInt(arrayList.get(i).getYear());
            softAssert.assertTrue(year<2023, "checking the value of year should be less than future year");
        }
        //to check the failures of soft assert use assert all in the end
        softAssert.assertAll();
    }

    @Test(description = "this is to check with two query param - id year and slug nation")
    public void getDataWithIdYearNSlugNation(){
        //calling the api
        response = apiHelper.getUsaData(ParamValues.id_year, ParamValues.slug_nation);

        //checking the param as per request
        softAssert.assertEquals(response.getStatusCode(),200,"check the status code on correct param");
        ArrayList<Datum> arrayList = response.getData().getUsaData().getData();
        for (int i = 0; i < arrayList.size(); i++) {
            softAssert.assertEquals(arrayList.get(i).getSlugNation(), ParamValues.slugNationValue, "checking the value of slug nation");
            year=arrayList.get(i).getIDYear();
            softAssert.assertTrue(year<2023, "checking the value of id year should be less than future year");
        }
        //to check the failures of soft assert use assert all in the end
        softAssert.assertAll();
    }

    @Test(description = "this is to check with two query param which are invalid")
    public void getDataWithInvalidParam(){
        //calling the api
        response = apiHelper.getUsaData("ABC","2020");

        //checking the param as per request
        softAssert.assertEquals(response.getStatusCode(),400,"check the status code on wrong param");
        softAssert.assertEquals(response.getError().getClass(),"ErrorCode","checking the errorCode");
        softAssert.assertEquals(response.getError().getErrMsg(),"errorMsg","checking the error message");
        //to check the failures of soft assert use assert all in the end
        softAssert.assertAll();
    }
}
