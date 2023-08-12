package api.testsApi.project;

import api.models.ResultResponse;
import api.models.parameters.project.ProjectProperties;
import api.steps.BaseApiSteps;
import api.steps.ProjectApiSteps;
import api.testsApi.BaseApiTest;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static utils.MyRandomData.getRandomNumber;

public class GetProjectByIdApiTest extends BaseApiTest {
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    private String projectID;
    private static final String PROJECT_NAME = "project" + getRandomNumber();
    @BeforeMethod
    @Description("Set up test data")
    public void setupData(){projectID = projectApiSteps.createProjectRequiredFields(PROJECT_NAME);}
    @Test
    @Description("")
    @Step("")
    public void getProjectByIdPositiveApiTest(){
       ResultResponse<ProjectProperties> projectPropertiesPesultResponce = projectApiSteps.getProjectById(projectID);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(projectPropertiesPesultResponce.getResult().getId(),projectID,"The project Id isn't match");
        softAssert.assertEquals(projectPropertiesPesultResponce.getResult().getName(),PROJECT_NAME, "The project's name sn't match");
        softAssert.assertAll();
    }
    @Test
    @Description("")
    @Step("")
    public void getProjectByIdEmptyNegativeApiTest(){
        ResultResponse<ProjectProperties> projectPropertiesResultResponse = projectApiSteps.getProjectById("");
        Assert.assertNull(projectPropertiesResultResponse.getResult(),"The project is shown after requesting with empty Id");
    }
    @Test
    @Description("")
    @Step("")
    public void getProjectByIdUnexistingNegativeApiTest(){
        ResultResponse<ProjectProperties>projectPropertiesResultResponse = projectApiSteps.getProjectById(projectID + projectID);
        Assert.assertNull(projectPropertiesResultResponse.getResult(), "The project is shown with unexisting Id");
    }
    @AfterMethod(alwaysRun = true)
    @Description("Cleaning up test data")
    public void removeDataAfterTest(){projectApiSteps.deleteProject(projectID);}

}
