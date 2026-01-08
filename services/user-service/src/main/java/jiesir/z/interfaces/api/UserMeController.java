package jiesir.z.interfaces.api;

import jakarta.validation.Valid;
import jiesir.z.application.me.GetMeUseCase;
import jiesir.z.application.profile.UpdateProfileUseCase;
import jiesir.z.infrastructure.api.dto.UpdateProfileRequest;
import jiesir.z.infrastructure.api.dto.UserProfileResponse;
import jiesir.z.shared.web.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/me")
@RequiredArgsConstructor
public class UserMeController {

    private final GetMeUseCase getMe;
    private final UpdateProfileUseCase updateProfile;

    @GetMapping
    public ApiResponse<UserProfileResponse> me(
            @RequestHeader(name="X-Tenant-Id", defaultValue="0") long tenantId,
            @RequestHeader("X-User-Id") long userId) {
        return ApiResponse.ok(UserProfileResponse.from(getMe.execute(tenantId, userId)));
    }

    @PutMapping
    public ApiResponse<Void> update(
            @RequestHeader(name="X-Tenant-Id", defaultValue="0") long tenantId,
            @RequestHeader("X-User-Id") long userId,
            @Valid @RequestBody UpdateProfileRequest req) {
        updateProfile.execute(tenantId, userId, req.getNickname(), req.getAvatarUrl());
        return ApiResponse.ok();
    }
}
