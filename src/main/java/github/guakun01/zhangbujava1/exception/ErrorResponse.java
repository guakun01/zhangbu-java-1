package github.guakun01.zhangbujava1.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String bizErrorCode;

    private ServiceException.ErrorType errorType;

    private String message;

    private int statusCode;

}
