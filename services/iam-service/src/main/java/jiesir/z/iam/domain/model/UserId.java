package jiesir.z.iam.domain.model;

public record UserId(long value) {
    public static UserId of(long v) { return new UserId(v); }
}
