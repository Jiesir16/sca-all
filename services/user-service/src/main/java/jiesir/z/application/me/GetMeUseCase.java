package jiesir.z.application.me;

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
public class GetMeUseCase {
    private final UserRepository userRepository;

    public User execute(long tenantId, long userId) {
        return userRepository.findById(TenantId.of(tenantId), UserId.of(userId))
                .orElseThrow(() -> new BizException(ErrorCode.USER_NOT_FOUND, "用户不存在"));
    }
}
