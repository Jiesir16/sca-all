package jiesir.z.domain.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class User {
    private final UserId id;
    private final TenantId tenantId;
    private final String userNo;

    private String nickname;
    private String avatarUrl;
    private String phone;
    private String email;
    private UserStatus status;

    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(UserId id, TenantId tenantId, String userNo,
                String nickname, String avatarUrl, String phone, String email,
                UserStatus status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.tenantId = tenantId;
        this.userNo = userNo;
        this.nickname = nickname;
        this.avatarUrl = avatarUrl;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void updateProfile(String nickname, String avatarUrl) {
        if (status != UserStatus.NORMAL) {
            throw new IllegalStateException("user status not allow update: " + status);
        }
        if (nickname != null) this.nickname = nickname;
        if (avatarUrl != null) this.avatarUrl = avatarUrl;
        this.updatedAt = LocalDateTime.now();
    }
}