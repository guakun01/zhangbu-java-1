package github.guakun01.zhangbujava1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(ServiceException.class)
  ResponseEntity<?> handleServiceException(ServiceException ex) {
     return ResponseEntity.status(ex.getStatusCode() != 0 ? ex.getStatusCode() : HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .body(
                            ErrorResponse.builder()
                                    .bizErrorCode(ex.getErrorCode())
                                    .statusCode(ex.getStatusCode())
                                    .errorType(ex.getErrorType())
                                    .message(ex.getMessage())
                                    .build());
  }

}
