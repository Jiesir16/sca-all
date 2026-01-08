package jiesir.z.shared.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private String code;
    private String message;
    private T data;

    public static <T> ApiResponse<T> ok(T data) { return new ApiResponse<>("0", "OK", data); }
    public static ApiResponse<Void> ok() { return new ApiResponse<>("0", "OK", null); }
    public static <T> ApiResponse<T> fail(String code, String msg) { return new ApiResponse<>(code, msg, null); }
}
