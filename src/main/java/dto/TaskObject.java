package dto;

public class TaskObject {
    public String id;
    public String assigner;
    public String project_id;
    public String section_id;
    public String order;
    public String content;
    public String description;
    public String completed;
    public Object label_ids;
    public String priority;
    public String comment_count;
    public String creator;
    public String created;
    public Due due;
    public String url;

    public class Due {
        public String date;
        public String string;
        public String lang;
        public String recurring;
    }


}
