package api.steps;

import api.models.ResultResponse;
import api.models.parameters.BodyCommon;
import api.models.parameters.users.CreateUser;
import api.models.parameters.users.UserId;
import api.models.parameters.users.UserProperties;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import static api.enums.UserRoles.USER;
import static api.methods.UserMethods.*;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;
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
        response.then().statusCode(SC_OK);
        ResultResponse result = response.as(ResultResponse.class);
        return result.getResult().toString();
    }

    public ResultResponse<UserProperties> getUserById(String userId) {
        BodyCommon bodyCommon = BodyCommon.builder()
                .params(new UserId(Integer.valueOf(userId)))
                .method(GET_USER)
                .build();
        Response response = postRequest(userName, token, bodyCommon);
        response.then().statusCode(SC_OK);
        return response.as(new TypeRef<ResultResponse<UserProperties>>() {

            }
        );
    }


    public boolean deleteUser(String userID) {
        BodyCommon bodyCommon = BodyCommon.builder()
                .params(new UserId(Integer.valueOf(userID)))
                .method(DELETE_USER)
                .build();
        Response response = postRequest(userName, token, bodyCommon);
        response.then().statusCode((SC_OK));
        return (boolean) response.as(ResultResponse.class).getResult();
    }
}
