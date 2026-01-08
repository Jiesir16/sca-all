package jiesir.z.iam.shared.web;

import lombok.*;

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
