package setUp;

import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class TestSetUp {
public SoftAssert softAssert;

/*
this is the before method it will be  called before every test method
and initiate the soft assert
 */
@BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
    softAssert = new SoftAssert();
}

}
