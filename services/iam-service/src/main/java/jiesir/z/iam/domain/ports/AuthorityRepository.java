package jiesir.z.iam.domain.ports;

import jiesir.z.iam.domain.model.*;

import java.util.List;

public interface AuthorityRepository {
    List<Authority> findAuthoritiesByUser(TenantId tenantId, UserId userId);
}
