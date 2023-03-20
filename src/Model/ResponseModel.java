package Model;

public class ResponseModel {
    private String Status;
    private String Comments;
    private String Message;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    public ResponseModel(){

    }

    public ResponseModel(String msg, String stts, String comments ){
        this.Message = msg;
        this.Status = stts;
        this.Comments = comments;

    }

}
