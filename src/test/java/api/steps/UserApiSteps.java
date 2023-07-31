package api.steps;

import api.models.ResultResponse;
import api.models.parameters.BodyCommon;
import api.models.parameters.users.CreateUser;
import api.models.parameters.users.UserIdResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static api.enums.UserRoles.USER;
import static api.methods.User.CREATE_USER;
import static api.methods.User.DELETE_USER;
import static utils.UseProperties.token;
import static utils.UseProperties.userName;

public class UserApiSteps extends BaseApiSteps {
    public String createUser(String username, String password) {
        CreateUser createUser = CreateUser.builder()
                .username(username)
                .password(password)
                .name(username)
                .email(username + "@gmail.com")
                .role(USER.getRole())
                .build();
        BodyCommon bodyCommon = BodyCommon.builder()
                .params(createUser)
                .method(CREATE_USER)
                .build();
        Response response = postRequest(userName, token, bodyCommon);
        response.then().statusCode(200);
        ResultResponse result = response.as(ResultResponse.class);
        return result.getResult().toString();
    }

    public boolean deleteUser(String userID) {
        BodyCommon bodyCommon = BodyCommon.builder()
                .params(new UserIdResponse(Integer.valueOf(userID)))
                .method(DELETE_USER)
                .build();
        Response response = postRequest(userName, token, bodyCommon);
        return (boolean) response.as(ResultResponse.class).getResult();
    }
}
