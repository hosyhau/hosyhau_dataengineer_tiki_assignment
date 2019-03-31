package tiki.vn.assignment.exception;

public class APIException extends RuntimeException{

    private String message;

    private String code;


    public APIException(String message){
        super(message);
        this.message = message;
    }
}
