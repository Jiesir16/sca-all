package jiesir.z.application.profile;

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
public class UpdateProfileUseCase {
    private final UserRepository repo;

    public void execute(long tenantId, long userId, String nickname, String avatarUrl) {
        User user = repo.findById(TenantId.of(tenantId), UserId.of(userId))
                .orElseThrow(() -> new BizException(ErrorCode.USER_NOT_FOUND, "用户不存在"));

        try {
            user.updateProfile(nickname, avatarUrl);
        } catch (IllegalStateException e) {
            throw new BizException(ErrorCode.USER_STATUS_NOT_ALLOW, "用户状态不允许修改资料");
        }

        repo.save(user);
    }
}
