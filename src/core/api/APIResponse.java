package src.core.api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;

public class APIResponse {
    Response response;
    public APIResponse (Response response){
        this.response = response;
    }
    public APIResponse getAll(){
        response.then().log().all();
        return this;
    }
    public String getBody(){
        return response.getBody().asString();
    }
    public APIResponse getStatusCode(){
        response.then().log().status();
        return this;
    }

}