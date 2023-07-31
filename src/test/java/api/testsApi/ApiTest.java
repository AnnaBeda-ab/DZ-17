package api.testsApi;

import api.steps.ProjectApiSteps;
import api.steps.TaskApiSteps;
import api.steps.UserApiSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class ApiTest extends BaseApiTest {
    private static String username;
    private static String password;
    private static String projectID;
    private static String taskID;
    private static String userID;
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    TaskApiSteps taskApiSteps = new TaskApiSteps();
    UserApiSteps userApiSteps = new UserApiSteps();


    @Test
    public void projectCreationTest() {
        projectID = projectApiSteps.createProjectRequiredFields("New Project");
    }

    @Test
    public void taskCreationTest() {
        taskID = taskApiSteps.createTaskRequiredFields("New Task", Integer.valueOf(projectID));

    }

    @Test

    public void userCreationTest() {
        username = "user" + randomAlphanumeric(10);
        password = "myTestPassword";
        userID = userApiSteps.createUser(username, password);
    }

    @Test
    public void projectDeletingTest() {
        boolean isDeleted = projectApiSteps.deleteProject(projectID);
        Assert.assertTrue(isDeleted, "Project wasn't deleted");
    }

    @Test
    public void taskDeletingTest() {
        boolean isDeleted = taskApiSteps.deleteTask(taskID);
        Assert.assertTrue(isDeleted, "Task wasn't deleted");
    }

    @Test
    public void userDeletingTest() {
        boolean isDeleted = userApiSteps.deleteUser(userID);
        Assert.assertTrue(isDeleted, "User wasn't deleted");
    }

}
