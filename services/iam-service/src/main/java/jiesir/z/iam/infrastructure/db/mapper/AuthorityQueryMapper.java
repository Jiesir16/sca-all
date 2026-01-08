package jiesir.z.iam.infrastructure.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthorityQueryMapper {
    List<String> selectPermCodesByUser(@Param("tenantId") long tenantId,
                                       @Param("userId") long userId);
}
