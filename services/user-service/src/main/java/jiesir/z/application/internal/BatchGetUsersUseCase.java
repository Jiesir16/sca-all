package jiesir.z.application.internal;

import jiesir.z.domain.model.TenantId;
import jiesir.z.domain.model.User;
import jiesir.z.domain.model.UserId;
import jiesir.z.domain.ports.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BatchGetUsersUseCase {
    private final UserRepository repo;

    public List<User> execute(long tenantId, List<Long> userIds) {
        List<UserId> ids = (userIds == null) ? List.of() : userIds.stream().map(UserId::of).toList();
        return repo.findByIds(TenantId.of(tenantId), ids);
    }
}
