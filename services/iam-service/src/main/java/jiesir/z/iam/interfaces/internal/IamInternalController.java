package jiesir.z.iam.interfaces.internal;

import jiesir.z.iam.application.internal.GetAuthoritiesUseCase;
import jiesir.z.iam.shared.web.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/internal/iam")
@RequiredArgsConstructor
public class IamInternalController {

    private final GetAuthoritiesUseCase getAuthorities;

    @GetMapping("/users/{userId}/authorities")
    public ApiResponse<List<String>> authorities(
            @RequestHeader(name="X-Tenant-Id", defaultValue="0") long tenantId,
            @PathVariable long userId) {
        return ApiResponse.ok(getAuthorities.execute(tenantId, userId));
    }
}
