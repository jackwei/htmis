package com.git.db.mapper;

import com.git.db.beans.SysUser;
import com.git.db.beans.SysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysUserMapper {
    
	int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    List<SysUser> selectByUserCondition(SysUser sysUser,RowBounds rb);
    
    int countByUserCondition(SysUser sysUser);
    
    SysUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    Long isUniqueUserCode(@Param("id") Long id, @Param("usercode") String usercode);
    
    SysUser findByUserCode(String usercode);
    
    List<SysUser> selectAllUser();
    
    int changeUserStatus(SysUser record);
    
    int updatePassword(SysUser record);
    
}