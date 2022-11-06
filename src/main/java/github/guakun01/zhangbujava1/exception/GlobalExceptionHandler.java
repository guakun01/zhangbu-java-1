package github.guakun01.zhangbujava1.exception;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import github.guakun01.zhangbujava1.exception.ServiceException.ErrorType;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(ServiceException.class)
  ResponseEntity<?> handleServiceException(ServiceException ex) {
    return ResponseEntity
        .status(ex.getStatusCode() != 0 ? ex.getStatusCode() : HttpStatus.INTERNAL_SERVER_ERROR.value())
        .body(
            ErrorResponse.builder()
                .bizErrorCode(ex.getErrorCode())
                .statusCode(ex.getStatusCode())
                .errorType(ex.getErrorType())
                .message(ex.getMessage())
                .build());
  }

  @ExceptionHandler(IncorrectCredentialsException.class)
  ResponseEntity<?> handleIncorrectCredentialsException(IncorrectCredentialsException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST.value())
        .body(
            ErrorResponse.builder()
                .bizErrorCode("INCORRECT_CREDENTIALS")
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .errorType(ErrorType.CLINET)
                .message("User try to find gua use wrong way.")
                .build());
  }

}
