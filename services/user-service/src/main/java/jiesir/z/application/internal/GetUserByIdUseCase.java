package jiesir.z.application.internal;

import jiesir.z.domain.model.TenantId;
import jiesir.z.domain.model.User;
import jiesir.z.domain.model.UserId;
import jiesir.z.domain.ports.UserRepository;
import jiesir.z.shared.error.BizException;
import jiesir.z.shared.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserByIdUseCase {
    private final UserRepository repo;

    public User execute(long tenantId, long userId) {
        return repo.findById(TenantId.of(tenantId), UserId.of(userId))
                .orElseThrow(() -> new BizException(ErrorCode.USER_NOT_FOUND, "用户不存在"));
    }
}
