package services;

import configuration.Constant;
import com.google.gson.Gson;
import dto.TaskObject;
import src.core.api.APIRequest;
import src.core.api.APIResponse;

public class ManageTaskService {
    public void reOpenTaskAPI(String id,String token){
        String address = String.format("https://api.todoist.com/rest/v1/tasks/%s/reopen", id);
        APIRequest apiRequest = new APIRequest();
        apiRequest
            .setInstances()
            .setToken(token)
            .post(address);
    }
    public APIResponse getDataRequest(String token)
    {
        APIRequest apiRequest = new APIRequest();
        APIResponse res = apiRequest.setBaseURI(Constant.API_Task)
                .setInstances()
                .setToken(token)
                .getResponse();
        return res;
    }
    public TaskObject[] getTaskDetail(String token){
        APIResponse response = getDataRequest(token);
        String a = response.getBody();
        Gson gson = new Gson();
        TaskObject[] taskObject = gson.fromJson(a,TaskObject[].class);
        return taskObject;
    }
    public String getNewestId(String token)
    {
        TaskObject[] nameObject = getTaskDetail(token);
        return nameObject[nameObject.length - 1].id;
    }
}
