package com.git.db.mapper;

import com.git.db.beans.SysRole;
import com.git.db.beans.SysRoleExample;
import com.git.db.beans.SysUser;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysRoleMapper {
    int countByExample(SysRoleExample example);

	int deleteByExample(SysRoleExample example);

	int deleteByPrimaryKey(Long roleId);

	int insert(SysRole record);

	int insertSelective(SysRole record);

	List<SysRole> selectByExampleWithRowbounds(SysRoleExample example,
			RowBounds rowBounds);

	List<SysRole> selectByExample(SysRoleExample example);

	SysRole selectByPrimaryKey(Long roleId);

	int updateByExampleSelective(@Param("record") SysRole record,
			@Param("example") SysRoleExample example);

	int updateByExample(@Param("record") SysRole record,
			@Param("example") SysRoleExample example);

	int updateByPrimaryKeySelective(SysRole record);

	int updateByPrimaryKey(SysRole record);
	
	List<SysRole> selectByCondition(SysRole sysRole,RowBounds rb);
	
	int countByCondition(SysRole sysRole);
	
	Long isUniqueRoleName(@Param("id") Long id, @Param("roleName") String roleName);
}