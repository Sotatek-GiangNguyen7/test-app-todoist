package services;

import configuration.Constant;
import com.google.gson.Gson;
import com.jayway.restassured.http.ContentType;
import dto.ProjectObject;
import src.core.api.APIRequest;
import src.core.api.APIResponse;

public class ManageProjectService {

    public void createProjectAPI(String token, String name){
        APIRequest apiRequest = new APIRequest();
        apiRequest
                .setInstances()
                .setToken(token)
                .setContentType(ContentType.JSON)
                .setBody("name", name)
                .post(Constant.API_PROJECT);
    }
    public APIResponse getDataRequest(String token)
    {
        APIRequest apiRequest = new APIRequest();
        APIResponse res = apiRequest.setBaseURI(Constant.API_PROJECT)
                .setInstances()
                .setToken("abeab110d8c29bbfab9fae46da9f3e21fffbd436")
                .getResponse();
        return res;
    }
    public ProjectObject[] getProjectDetail(String token){
        APIResponse response = getDataRequest(token);
        String a = response.getBody();
        Gson gson = new Gson();
        ProjectObject[] nameObject = gson.fromJson(a,ProjectObject[].class);
        return nameObject;
    }
    public String getNameNewestName(String token)
    {
        ProjectObject[] nameObject = getProjectDetail(token);
        return nameObject[nameObject.length - 1].name;
    }
}
