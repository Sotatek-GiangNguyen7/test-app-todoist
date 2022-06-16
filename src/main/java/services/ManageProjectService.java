package services;

import com.jayway.restassured.http.ContentType;
import pageobject.CreateProjectPage;
import src.core.api.APIRequest;

public class ManageProjectService {

    public void createProjectAPI(){
        APIRequest apiRequest = new APIRequest();
        apiRequest
                .setInstances()
                .setToken("abeab110d8c29bbfab9fae46da9f3e21fffbd436")
                .setContentType(ContentType.JSON)
                .setBody("name","Shopping list")
                .post("https://api.todoist.com/rest/v1/projects");
    }
}
