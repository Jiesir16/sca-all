package jiesir.z.shared.web;

import jiesir.z.shared.error.BizException;
import jiesir.z.shared.error.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BizException.class)
    public ResponseEntity<ApiResponse<Void>> biz(BizException e) {
        return ResponseEntity.badRequest().body(ApiResponse.fail(e.getCode().name(), e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> valid(MethodArgumentNotValidException e) {
        String msg = e.getBindingResult().getFieldErrors().stream()
                .findFirst().map(fe -> fe.getField() + " " + fe.getDefaultMessage())
                .orElse("参数错误");
        return ResponseEntity.badRequest().body(ApiResponse.fail(ErrorCode.PARAM_INVALID.name(), msg));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> other(Exception e) {
        return ResponseEntity.internalServerError().body(ApiResponse.fail(ErrorCode.SYS_ERROR.name(), "系统异常"));
    }
}
