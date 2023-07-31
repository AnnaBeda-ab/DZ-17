package api.steps;

import api.models.parameters.BodyCommon;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.UseProperties;

import static utils.UseProperties.apiEndpoint;


public class BaseApiSteps {
public Response postRequest(String userName,String token, BodyCommon bodyCommon){
return RestAssured.given()
        .auth().basic(userName,token)
        .body(bodyCommon)
        .when()
        .post(apiEndpoint);
}
}
