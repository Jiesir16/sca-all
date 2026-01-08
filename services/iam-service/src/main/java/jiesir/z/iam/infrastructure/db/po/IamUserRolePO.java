package jiesir.z.iam.infrastructure.db.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("iam_user_role")
public class IamUserRolePO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long tenantId;
    private Long userId;
    private Long roleId;
    private LocalDateTime createdAt;
}
