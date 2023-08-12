package api.testsApi.project;

import api.steps.ProjectApiSteps;
import api.testsApi.BaseApiTest;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static utils.MyRandomData.getRandomNumber;

public class RemoveProjectApiTest extends BaseApiTest {
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    private String projectID;
    private static final String PROJECT_NAME = "project" + getRandomNumber();
    @BeforeMethod
    @Description("Set up test data")
    public void setupData(){projectID = projectApiSteps.createProjectRequiredFields(PROJECT_NAME);}
    @Test
    @Description("")
    @Step
    public void deleteProjectPositiveApiTest(){
        Boolean isDeleted = projectApiSteps.deleteProject(projectID);
        Assert.assertTrue(isDeleted,"The project wasn't deleted");
    }
    @Test
    @Description("")
    @Step("")
    public void deleteProjectTwiceNegativeCase(){
        projectApiSteps.deleteProject(projectID);
        Boolean isDeleted = projectApiSteps.deleteProject(projectID);
        Assert.assertFalse(isDeleted,"The project can be deleted twice");
    }
    @Test
    @Description("")
    @Step("")
    public void deleteProjectUnexistedIdNegativeTest(){
        Boolean isDeleted = projectApiSteps.deleteProject(projectID+projectID);
        Assert.assertFalse(isDeleted,"Some project with unexisted id is deleted");
    }
    @Test
    @Description("")
    @Step("")
    public void deleteProjectEmptyIdNegativeTest(){
        Boolean isDeleted = projectApiSteps.deleteProject("");
        Assert.assertFalse(isDeleted,"Some project with empty id is deleted");
    }


}
