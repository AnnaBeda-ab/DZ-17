package api.steps;

import api.models.ResultResponse;
import api.models.parameters.BodyCommon;
import api.models.parameters.project.CreateProject;
import api.models.parameters.project.ProjectIdResponse;
import io.restassured.response.Response;

import static api.methods.Project.CREATE_PROJECT;
import static api.methods.Project.DELETE_PROJECT;
import static utils.UseProperties.token;
import static utils.UseProperties.userName;


public class ProjectApiSteps extends BaseApiSteps {
    public String createProjectRequiredFields(String projectName){
        CreateProject createProject = CreateProject.builder()
                .name(projectName)
                .build();
        BodyCommon bodyCommon = BodyCommon.builder()
                .params(createProject)
                .method(CREATE_PROJECT)
                .build();
        Response response = postRequest(userName, token, bodyCommon);
        response.then().statusCode(200);
        ResultResponse result = response.as(ResultResponse.class);
        return result.getResult().toString();
    }
    public boolean deleteProject (String projectID){
        BodyCommon bodyCommon = BodyCommon.builder()
                .params(new ProjectIdResponse(Integer.valueOf(projectID)))
                .method(DELETE_PROJECT)
                .build();
        Response response = postRequest(userName,token,bodyCommon);
        return (boolean) response.as(ResultResponse.class).getResult();
    }
}
