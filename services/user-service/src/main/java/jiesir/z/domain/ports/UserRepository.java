package jiesir.z.domain.ports;

import jiesir.z.domain.model.TenantId;
import jiesir.z.domain.model.User;
import jiesir.z.domain.model.UserId;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(TenantId tenantId, UserId userId);
    List<User> findByIds(TenantId tenantId, List<UserId> userIds);

    void save(User user);   // update 用（本期先实现更新资料）
}
