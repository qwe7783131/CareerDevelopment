package com.bugmaker.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {

	int insertUserRole(@Param("userId") String userId, @Param("roleId") String roleId);
}
