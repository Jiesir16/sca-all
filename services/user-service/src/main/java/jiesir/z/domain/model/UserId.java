package jiesir.z.domain.model;

public record UserId(long value) {

    public static UserId of(long value) {
        return new UserId(value);
    }

}
