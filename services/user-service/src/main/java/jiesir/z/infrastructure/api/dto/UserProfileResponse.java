package jiesir.z.infrastructure.api.dto;

import jiesir.z.domain.model.User;
import lombok.Data;

@Data
public class UserProfileResponse {
    private Long id;
    private String userNo;
    private String nickname;
    private String avatarUrl;
    private String phone;
    private String email;
    private Integer status;

    public static UserProfileResponse from(User u) {
        UserProfileResponse r = new UserProfileResponse();
        r.setId(u.getId().value());
        r.setUserNo(u.getUserNo());
        r.setNickname(u.getNickname());
        r.setAvatarUrl(u.getAvatarUrl());
        r.setPhone(u.getPhone());
        r.setEmail(u.getEmail());
        r.setStatus(u.getStatus().code());
        return r;
    }
}
