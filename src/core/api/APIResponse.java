package src.core.api;

import com.jayway.restassured.response.Response;

public class APIResponse {
    Response response;

    public APIResponse(Response response) {
        this.response = response;
    }

    public APIResponse getAll() {
        response.then().log().all();
        return this;
    }

    public String getBody() {
        return response.getBody().asString();
    }

    public APIResponse getStatusCode() {
        response.then().log().status();
        return this;
    }

}