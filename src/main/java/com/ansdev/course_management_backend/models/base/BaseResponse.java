package com.ansdev.course_management_backend.models.base;


import com.ansdev.course_management_backend.exception.BaseException;
import com.ansdev.course_management_backend.exception.types.NotFoundExceptionType;
import com.ansdev.course_management_backend.models.enums.response.ResponseMessages;
import com.ansdev.course_management_backend.models.enums.response.SuccesResponseMessages;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import static com.ansdev.course_management_backend.models.enums.response.ErrorResponseMessages.NOT_FOUND;
import static com.ansdev.course_management_backend.models.enums.response.SuccesResponseMessages.SUCCESS;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {

    HttpStatus status;
    Meta meta;
    T data;

    @Data
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder(access = AccessLevel.PRIVATE)
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static final class Meta{

        String key;
        String message;

        public static Meta of(String key, String message){
            return Meta.builder()
                    .key(key)
                    .message(message)
                    .build();
        }

        public static Meta of(ResponseMessages responseMessages) {
            return of(responseMessages.key(), responseMessages.message());
        }

        public static Meta of(BaseException e) {
            if (e.getResponseMessage().equals(NOT_FOUND)) {
                NotFoundExceptionType notFoundExceptionType = e.getNotFoundExceptionType();
                return of(
                        String.format(e.getResponseMessage().key(), notFoundExceptionType.getTarget().toLowerCase()),
                        String.format(e.getResponseMessage().message(),notFoundExceptionType.getTarget().toLowerCase(), notFoundExceptionType.getFields().toString())
                );
            }

            return of(e.getResponseMessage());

        }

    }


    public static <T> BaseResponse<T> success(T data) {
        return BaseResponse.<T>builder()
                .status(HttpStatus.OK)
                .data(data)
                .meta(Meta.of(SUCCESS))
                .build();
    }

    public static <T> BaseResponse<T> success() {
        return success(null);
    }

    public static BaseResponse<?> error(BaseException e) {
        return BaseResponse.builder()
                .meta(Meta.of(e))
                .status(e.getResponseMessage().status())
                .build();
    }


}


