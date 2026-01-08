package jiesir.z.interfaces.internal;

import jiesir.z.application.internal.BatchGetUsersUseCase;
import jiesir.z.application.internal.GetUserByIdUseCase;
import jiesir.z.infrastructure.api.dto.UserProfileResponse;
import jiesir.z.shared.web.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/internal/users")
@RequiredArgsConstructor
public class UserInternalController {

    private final GetUserByIdUseCase getById;
    private final BatchGetUsersUseCase batchGet;

    @GetMapping("/{userId}")
    public ApiResponse<UserProfileResponse> get(
            @RequestHeader(name="X-Tenant-Id", defaultValue="0") long tenantId,
            @PathVariable long userId) {
        return ApiResponse.ok(UserProfileResponse.from(getById.execute(tenantId, userId)));
    }

    @PostMapping("/batch")
    public ApiResponse<List<UserProfileResponse>> batch(
            @RequestHeader(name="X-Tenant-Id", defaultValue="0") long tenantId,
            @RequestBody List<Long> userIds) {
        var users = batchGet.execute(tenantId, userIds).stream().map(UserProfileResponse::from).toList();
        return ApiResponse.ok(users);
    }
}