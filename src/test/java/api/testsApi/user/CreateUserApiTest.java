package api.testsApi.user;

import api.dataptoviderApi.NegativeUserData;
import api.steps.UserApiSteps;
import api.testsApi.BaseApiTest;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static utils.MyRandomData.getRandomNumber;

public class CreateUserApiTest extends BaseApiTest {
    UserApiSteps userApiSteps = new UserApiSteps();
    private static final String USERNAME = "user" + getRandomNumber();
    private static final String PASSWORD = "myPassword" + getRandomNumber();
    private String userId;

    @BeforeMethod
    @Description("Set up test data")
    public void setupData() {
        userId = userApiSteps.createUser(USERNAME, PASSWORD);
    }

    @Test
    @Description("Checking positive case of user creation")
    @Step("User creation valid data")
    public void userCreationPositiveCaseApiTest() {
//        userId = userApiSteps.createUser(USERNAME, PASSWORD);
//        System.out.println(userId);
        Assert.assertNotNull(userId, "User wasn't created");
    }

    @Test
    @Description("Checking negative case of existed user creation")
    @Step("User creation with existed creds")
    public void userExistedCreationNegativeCaseApiTest() {
        userApiSteps.createUser(USERNAME, PASSWORD);
        Assert.assertFalse(Boolean.valueOf(userId), "The user with existed username and password was created");
    }

    @Test(dataProvider = "NegativeUserData", dataProviderClass = NegativeUserData.class)
    @Description("Checking negative case of user creation")
    @Step("User creation negative case with username {0} and password {1}")
    public void userCreationNegativeCaseApiTest(String userName, String password) {
        String userIdNew = userApiSteps.createUser(userName, password);
        Assert.assertFalse(Boolean.valueOf(userIdNew), "User was created");
    }

    @AfterMethod(alwaysRun = true)
    @Description("Cleaning up test data")
   // @Step("Cleaning up test data (step)")
    public void removeDataAfterTest() {
        userApiSteps.deleteUser(userId);
    }
}
