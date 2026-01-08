package jiesir.z.infrastructure.db.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user_account")
public class UserAccountPO {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long tenantId;
    private String userNo;

    private String nickname;
    private String avatarUrl;
    private String phone;
    private String email;

    private Integer status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
