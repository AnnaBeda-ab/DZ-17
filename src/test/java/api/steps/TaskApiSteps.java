package api.steps;

import api.models.ResultResponse;
import api.models.parameters.BodyCommon;
import api.models.parameters.task.CreateTask;
import api.models.parameters.task.TaskId;
import io.restassured.response.Response;

import static api.methods.TaskMethods.CREATE_TASK;
import static api.methods.TaskMethods.DELETE_TASK;
import static utils.UseProperties.token;
import static utils.UseProperties.userName;

public class TaskApiSteps extends BaseApiSteps {
    public String createTaskRequiredFields(String title, Integer project_id){
        CreateTask createTask = CreateTask.builder()
                .title(title)
                .project_id(project_id)
                .build();
        BodyCommon bodyCommon = BodyCommon.builder()
                .params(createTask)
                .method(CREATE_TASK)
                .build();
        Response response = postRequest(userName,token, bodyCommon);
        response.then().statusCode(200);
        ResultResponse result = response.as(ResultResponse.class);
        return result.getResult().toString();
    }
    public boolean deleteTask (String taskID){
      BodyCommon bodyCommon = BodyCommon.builder()
              .params(new TaskId(Integer.valueOf(taskID)))
              .method(DELETE_TASK)
              .build();
      Response response = postRequest(userName,token,bodyCommon);
      return (boolean) response.as(ResultResponse.class).getResult();
    }
}
