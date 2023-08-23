package api.testsApi.user;

import api.models.ResultResponse;
import api.models.parameters.users.UserProperties;
import api.steps.UserApiSteps;
import api.testsApi.BaseApiTest;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static utils.MyRandomData.getRandomNumber;

public class GetUserApiTest extends BaseApiTest {
    UserApiSteps userApiSteps = new UserApiSteps();
    private ResultResponse<UserProperties> userPropertiesResultResponse;
    private static final String USER = "User" + getRandomNumber();
    private static final String PASSWORD = "MyPassword" + getRandomNumber();
    private String userId;

    @BeforeMethod
    @Description("Set up test data")
    public void setupData() {
        userId = userApiSteps.createUser(USER, PASSWORD);
    }

    @Test
    @Description("Checks getting exsisting user by Id")
    @Step("Get user by Id positive case")
    public void getUserByIdPositveApiTest() {
        userPropertiesResultResponse = userApiSteps.getUserById(userId);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(userPropertiesResultResponse.getResult().getId(), Integer.valueOf(userId), "No user was found with this name");
        softAssert.assertEquals(userPropertiesResultResponse.getResult().getName(), USER, "No user was found with this name");
        softAssert.assertAll();
    }

    @Test
    @Description("Checks getting unexisting user by Id")
    @Step("Get user by Id negative case (unexisting ID)")
    public void getUserByIdNegativeApiTest() {
        userPropertiesResultResponse = userApiSteps.getUserById(userId + "1");
        Assert.assertNull(userPropertiesResultResponse.getResult(), "Some user was found");
    }
    @Test
    @Description("Checks getting user by zero Id")
    @Step("Get user by Id negative case (ID=0)")
    public void getUserByZeroIdNegativeApiTest() {
        userPropertiesResultResponse = userApiSteps.getUserById( "0");
        Assert.assertNull(userPropertiesResultResponse.getResult(), "Some user was found");
    }

    @AfterMethod(alwaysRun = true)
    @Description("Cleaning up the data after test")
    public void removeDataAfterApiTest() {
        userApiSteps.deleteUser(userId);
    }
}
