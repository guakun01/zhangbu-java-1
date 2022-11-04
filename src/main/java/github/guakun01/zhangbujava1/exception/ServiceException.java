package github.guakun01.zhangbujava1.exception;

import lombok.Data;

@Data
public class ServiceException extends RuntimeException{

    public ServiceException(String message) {
        super(message);
    }

    private int statusCode;

    private String errorCode;

    private ErrorType errorType;

    public enum ErrorType {
        CLINET,
        SERVER,
        UKNOWN
    }
    
}
