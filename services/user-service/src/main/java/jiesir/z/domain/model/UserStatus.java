package jiesir.z.domain.model;

public enum UserStatus {
    NORMAL(1),
    FROZEN(2),
    CANCELED(3);
    private final int code;

    UserStatus(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }

    public static UserStatus from(int code) {
        for (var s : values()) if (s.code == code) return s;
        throw new IllegalArgumentException("unknown status: " + code);
    }
}
