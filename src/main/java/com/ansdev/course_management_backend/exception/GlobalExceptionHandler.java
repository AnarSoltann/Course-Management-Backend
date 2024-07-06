package com.ansdev.course_management_backend.exception;

import com.ansdev.course_management_backend.models.base.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler  {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponse<?>> handleBaseException(BaseException e) {
        return ResponseEntity.status(e.getResponseMessage().status()).body(BaseResponse.error(e));

    }

//    @ExceptionHandler(UsernameNotFoundException.class)
//   public ResponseEntity<BaseResponse<?>> handleUsernameNotFoundException(UsernameNotFoundException ex) {
//        BaseException baseException = (BaseException) ex.getCause();
//       return ResponseEntity.status(baseException.getResponseMessage().status()).body(BaseResponse.error(baseException));
//   }




}
