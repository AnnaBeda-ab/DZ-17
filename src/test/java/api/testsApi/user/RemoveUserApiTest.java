package api.testsApi.user;

import api.steps.UserApiSteps;
import api.testsApi.BaseApiTest;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static utils.MyRandomData.getRandomNumber;

public class RemoveUserApiTest extends BaseApiTest {
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
    @Description("Checks deleting of the user")
    @Step("Delete user positive case")
    public void deleteUserPositiveApiTest() {
        Boolean isDeleted = userApiSteps.deleteUser(userId);
        Assert.assertTrue(isDeleted.booleanValue(), "User was not deleted");
    }
    @Test
    @Description("Checks deleting of the unexisting user")
    @Step("Delete user negative case (unexisting user)")
    public void deleteUserUnexistNegativeApiTest() {
        Boolean isDeleted = userApiSteps.deleteUser(userId+"1");
        Assert.assertFalse(isDeleted.booleanValue(), "User was not deleted");
        userApiSteps.deleteUser(userId);
    }
    @Test
    @Description("Checks deleting of the existing user twice")
    @Step("Delete user negative case (existing user twice)")
    public void deleteUserExistNegativeApiTest() {
        userApiSteps.deleteUser(userId);
        Boolean isDeleted = userApiSteps.deleteUser(userId);
        Assert.assertFalse(isDeleted.booleanValue(), "User was not deleted");

    }
    @Test
    @Description("Checks deleting of the user with id=0")
    @Step("Delete user negative case (Id=0)")
    public void deleteUserZeroIdtNegativeApiTest() {
        Boolean isDeleted = userApiSteps.deleteUser("0");
        Assert.assertFalse(isDeleted.booleanValue(), "User was not deleted");
        userApiSteps.deleteUser(userId);}
}
