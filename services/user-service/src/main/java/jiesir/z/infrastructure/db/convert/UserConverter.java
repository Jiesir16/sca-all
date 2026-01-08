package jiesir.z.infrastructure.db.convert;

import jiesir.z.domain.model.TenantId;
import jiesir.z.domain.model.User;
import jiesir.z.domain.model.UserId;
import jiesir.z.domain.model.UserStatus;
import jiesir.z.infrastructure.db.po.UserAccountPO;

public class UserConverter {
    public static User toDomain(UserAccountPO po) {
        return new User(
                UserId.of(po.getId()),
                TenantId.of(po.getTenantId()),
                po.getUserNo(),
                po.getNickname(),
                po.getAvatarUrl(),
                po.getPhone(),
                po.getEmail(),
                UserStatus.from(po.getStatus()),
                po.getCreatedAt(),
                po.getUpdatedAt()
        );
    }

    public static void copyToPo(User domain, UserAccountPO po) {
        po.setId(domain.getId().value());
        po.setTenantId(domain.getTenantId().value());
        po.setUserNo(domain.getUserNo());
        po.setNickname(domain.getNickname());
        po.setAvatarUrl(domain.getAvatarUrl());
        po.setPhone(domain.getPhone());
        po.setEmail(domain.getEmail());
        po.setStatus(domain.getStatus().code());
        po.setCreatedAt(domain.getCreatedAt());
        po.setUpdatedAt(domain.getUpdatedAt());
    }
}
