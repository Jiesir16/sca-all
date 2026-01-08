package jiesir.z.iam.application.internal;

import jiesir.z.iam.domain.model.*;
import jiesir.z.iam.domain.ports.AuthorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAuthoritiesUseCase {

    private final AuthorityRepository repo;

    public List<String> execute(long tenantId, long userId) {
        return repo.findAuthoritiesByUser(TenantId.of(tenantId), UserId.of(userId))
                .stream().map(Authority::code).toList();
    }
}
