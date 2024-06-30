package com.ansdev.course_management_backend.exception;

import com.ansdev.course_management_backend.exception.types.NotFoundExceptionType;
import com.ansdev.course_management_backend.models.enums.response.ResponseMessages;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;

import static com.ansdev.course_management_backend.models.enums.response.ErrorResponseMessages.NOT_FOUND;
import static com.ansdev.course_management_backend.models.enums.response.ErrorResponseMessages.UNEXPECTED;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseException extends RuntimeException{

    ResponseMessages responseMessage;
    NotFoundExceptionType notFoundExceptionType;


    //todo: fix. it doest return dynamic message
    @Override
    public String getMessage() {return responseMessage.message();}

    public static BaseException of(ResponseMessages responseMessages){
        return BaseException.builder().responseMessage(responseMessages).build();
    }

    public  static BaseException unexpected(){return of(UNEXPECTED);}

   public static BaseException notFound(String target, String field, String value){
       return BaseException.builder()
               .responseMessage(NOT_FOUND)
               .notFoundExceptionType(
                       NotFoundExceptionType.of(target, Map.of(field,value))
               )
               .build();
   }


}
