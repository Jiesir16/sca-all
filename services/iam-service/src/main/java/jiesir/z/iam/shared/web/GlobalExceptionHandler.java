package jiesir.z.iam.shared.web;

import jiesir.z.iam.shared.error.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BizException.class)
    public ResponseEntity<ApiResponse<Void>> biz(BizException e) {
        return ResponseEntity.badRequest().body(ApiResponse.fail(e.getCode().name(), e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> valid(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest()
                .body(ApiResponse.fail(ErrorCode.PARAM_INVALID.name(), "参数错误"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> other(Exception e) {
        return ResponseEntity.internalServerError()
                .body(ApiResponse.fail(ErrorCode.SYS_ERROR.name(), "系统异常"));
    }
}
