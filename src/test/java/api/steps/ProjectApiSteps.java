package api.steps;

import api.models.ResultResponse;
import api.models.parameters.BodyCommon;
import api.models.parameters.project.CreateProject;
import api.models.parameters.project.ProjectId;
import api.models.parameters.project.ProjectProperties;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import java.lang.reflect.Type;
import java.util.List;

import static api.methods.ProjectMethods.*;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;
import static utils.UseProperties.token;
import static utils.UseProperties.userName;


public class ProjectApiSteps extends BaseApiSteps {
    public String createProjectRequiredFields(String projectName) {
        CreateProject createProject = CreateProject.builder()
                .name(projectName)
                .build();
        BodyCommon bodyCommon = BodyCommon.builder()
                .params(createProject)
                .method(CREATE_PROJECT)
                .build();
        Response response = postRequest(userName, token, bodyCommon);
        response.then().statusCode(SC_OK);
        ResultResponse result = response.as(ResultResponse.class);
        return result.getResult().toString();
    }

    public String createProjectAllFields(String projectName) {
        CreateProject createProject = CreateProject.builder()
                .name(projectName)
                .description("test project")
                .owner_id(1)
                .identifier("")
                .start_date("")
                .end_date("")
                .build();
        BodyCommon bodyCommon = BodyCommon.builder()
                .params(createProject)
                .method(CREATE_PROJECT)
                .build();
        Response response = postRequest(userName, token, bodyCommon);
        response.then().statusCode(SC_OK);
        ResultResponse result = response.as(ResultResponse.class);
        return result.getResult().toString();
    }

    public ResultResponse<ProjectProperties> getProjectById(String projectId) {
        BodyCommon bodyCommon = BodyCommon.builder()
                .params(new ProjectId(Integer.valueOf(projectId)))
                .method(GET_PROJECT_BY_ID)
                .build();
        Response response = postRequest(userName, token, bodyCommon);
        response.then().statusCode(SC_OK);
        return response.as(new TypeRef<ResultResponse<ProjectProperties>>() {
        });
    }

    public ResultResponse<List<ProjectProperties>> getAllProjects() {
        BodyCommon bodyCommon = BodyCommon.builder()
                .method(GET_ALL_PROJECTS)
                .build();
        Response response = postRequest(userName, token, bodyCommon);
        response.then().statusCode(SC_OK);
        return response.as(new TypeRef<ResultResponse<List<ProjectProperties>>>() {
        });
    }

    public boolean deleteProject(String projectID) {
        BodyCommon bodyCommon = BodyCommon.builder()
                .params(new ProjectId(Integer.valueOf(projectID)))
                .method(DELETE_PROJECT)
                .build();
        Response response = postRequest(userName, token, bodyCommon);
        return (boolean) response.as(ResultResponse.class).getResult();
    }
}
