package jiesir.z.domain.model;

public record TenantId(long value) {

    public static TenantId of(long v) { return new TenantId(v); }

}
