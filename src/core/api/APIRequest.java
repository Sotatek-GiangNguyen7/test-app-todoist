package src.core.api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.http.Method;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static com.jayway.restassured.RestAssured.*;

public class APIRequest {
    RequestSpecification request;

    JSONObject content = new JSONObject();
    public APIRequest setBaseURI (String baseURI){
        RestAssured.baseURI = baseURI;
        return this;
    }

    public APIRequest setInstances (){
        request = given();
        return this;
    }

    public APIRequest setContentType (ContentType Type){
        request.contentType(Type);
        return this;
    }

    public APIRequest setToken (String token){
        request.header("authorization", "Bearer " + token);
        return this;
    }

    public APIRequest setBody(String key, String value){
        content.put(key, value);
        return this;
    }

    public APIRequest post(String url){
        request.body(content.toString()).then().post(url).statusCode();
        return this;
    }

    public APIRequest getResponse (){
        request.get().then().log().all();
        return this;
    }
}