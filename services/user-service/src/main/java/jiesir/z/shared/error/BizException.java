package jiesir.z.shared.error;

import lombok.Getter;

@Getter
public class BizException extends RuntimeException {
    private final ErrorCode code;

    public BizException(ErrorCode code, String message) {
        super(message);
        this.code = code;
    }
}
