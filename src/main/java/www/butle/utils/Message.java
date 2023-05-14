package www.butle.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public class Message {
    private boolean isSuccess;
    private String message;

    public Message() {
    }

    public Message(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "isSuccess=" + isSuccess +
                ", message='" + message + '\'' +
                '}';
    }
    public static ResponseEntity<Message> getMessageResponseEntity(boolean delete, @PathVariable long id) {
        boolean result = delete;
        if(!result){
            Message message = new Message(false,"not found");
            return new ResponseEntity<Message>(message, HttpStatus.NOT_FOUND);
        }
        Message message = new Message(true, "deleted Successful");
        return new ResponseEntity<Message>(message,HttpStatus.OK);
    }
}
