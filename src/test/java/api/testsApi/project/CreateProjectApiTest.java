package api.testsApi.project;

import api.steps.ProjectApiSteps;
import api.testsApi.BaseApiTest;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static utils.MyRandomData.getRandomNumber;

public class CreateProjectApiTest extends BaseApiTest {
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    private static final String PROJECT_NAME = "project" + getRandomNumber();
    private String projectId;

    @Test
    @Description("")
    @Step("")
    public void createProjectRequiredFieldsPositiveApiTest() {
        projectId = projectApiSteps.createProjectRequiredFields(PROJECT_NAME);
        Assert.assertNotNull(projectId, "The project wasn't created");
    }

    @Test
    @Description("")
    @Step("")
    public void createProjectAllFieldsPositiveApiTest() {
        projectId = projectApiSteps.createProjectAllFields(PROJECT_NAME);
        Assert.assertNotNull(projectId, "The project wasn't created");
    }
    @Test
    @Description("")
    @Step("")
    public void createProjectNegativeApiTest(){
        projectId=projectApiSteps.createProjectRequiredFields("");
        Assert.assertFalse(Boolean.valueOf(projectId),"Project was created with empty required field");
    }

    @AfterMethod(alwaysRun = true)
    @Description("Cleaning up test data")
    public void removeDataAfterTest() {
        projectApiSteps.deleteProject(projectId);

    }


}
