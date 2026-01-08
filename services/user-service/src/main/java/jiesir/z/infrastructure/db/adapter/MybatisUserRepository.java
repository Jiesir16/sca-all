package jiesir.z.infrastructure.db.adapter;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jiesir.z.domain.model.TenantId;
import jiesir.z.domain.model.User;
import jiesir.z.domain.model.UserId;
import jiesir.z.domain.ports.UserRepository;
import jiesir.z.infrastructure.db.convert.UserConverter;
import jiesir.z.infrastructure.db.mapper.UserAccountMapper;
import jiesir.z.infrastructure.db.po.UserAccountPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MybatisUserRepository implements UserRepository {

    private final UserAccountMapper userAccountMapper;

    @Override
    public Optional<User> findById(TenantId tenantId, UserId userId) {
        UserAccountPO po = userAccountMapper.selectOne(Wrappers.<UserAccountPO>lambdaQuery()
                .eq(UserAccountPO::getTenantId, tenantId.value())
                .eq(UserAccountPO::getId, userId.value())
                .last("limit 1"));
        return Optional.ofNullable(po).map(UserConverter::toDomain);
    }

    @Override
    public List<User> findByIds(TenantId tenantId, List<UserId> userIds) {
        if (userIds == null || userIds.isEmpty()) return List.of();
        List<Long> ids = userIds.stream().map(UserId::value).toList();
        return userAccountMapper.selectList(Wrappers.<UserAccountPO>lambdaQuery()
                        .eq(UserAccountPO::getTenantId, tenantId.value())
                        .in(UserAccountPO::getId, ids))
                .stream().map(UserConverter::toDomain).toList();
    }

    @Override
    public void save(User user) {
        UserAccountPO po = new UserAccountPO();
        UserConverter.copyToPo(user, po);
        userAccountMapper.update(po, Wrappers.<UserAccountPO>lambdaQuery()
                .eq(UserAccountPO::getTenantId, user.getTenantId().value())
                .eq(UserAccountPO::getId, user.getId().value()));
    }
}
