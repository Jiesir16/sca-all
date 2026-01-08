package jiesir.z.iam.infrastructure.db.adapter;

import jiesir.z.iam.domain.model.*;
import jiesir.z.iam.domain.ports.AuthorityRepository;
import jiesir.z.iam.infrastructure.db.mapper.AuthorityQueryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MybatisAuthorityRepository implements AuthorityRepository {

    private final AuthorityQueryMapper queryMapper;

    @Override
    public List<Authority> findAuthoritiesByUser(TenantId tenantId, UserId userId) {
        List<String> codes = queryMapper.selectPermCodesByUser(
                tenantId.value(), userId.value());
        return codes.stream().distinct().map(Authority::new).toList();
    }
}
