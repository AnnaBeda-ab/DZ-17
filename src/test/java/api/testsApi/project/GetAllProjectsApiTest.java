package api.testsApi.project;

import api.models.ResultResponse;
import api.models.parameters.project.ProjectProperties;
import api.steps.ProjectApiSteps;
import api.testsApi.BaseApiTest;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static utils.MyRandomData.getRandomNumber;

public class GetAllProjectsApiTest extends BaseApiTest {
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    private static final String PROJECT_NAME = "project" + getRandomNumber();
    private String progectId;

    @BeforeMethod
    @Description("Set up test data")
    public void setupData() {
        progectId = projectApiSteps.createProjectRequiredFields(PROJECT_NAME);
    }

    @Test
    @Description("")
    @Step("")
    public void getAllProjectsPositiveTest() {
        ResultResponse<List<ProjectProperties>> projectPropertiesList = projectApiSteps.getAllProjects();
        Assert.assertTrue(projectPropertiesList.getResult().size() > 0, "The list of projects is empty ");
    }
    @AfterMethod(alwaysRun = true)
    @Description("Cleaning up test data")
    public void removeDataAfterTest(){projectApiSteps.deleteProject(progectId);}
}
