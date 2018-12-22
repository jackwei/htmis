package com.git.db.mapper;

import com.git.db.beans.SysGroup;
import com.git.db.beans.SysGroupExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysGroupMapper {
    int countByExample(SysGroupExample example);

    int deleteByExample(SysGroupExample example);

    int deleteByPrimaryKey(Long orgId);

    int insert(SysGroup record);

    int insertSelective(SysGroup record);

    List<SysGroup> selectByExampleWithRowbounds(SysGroupExample example, RowBounds rowBounds);

    List<SysGroup> selectByExample(SysGroupExample example);

    SysGroup selectByPrimaryKey(Long orgId);

    int updateByExampleSelective(@Param("record") SysGroup record, @Param("example") SysGroupExample example);

    int updateByExample(@Param("record") SysGroup record, @Param("example") SysGroupExample example);

    int updateByPrimaryKeySelective(SysGroup record);

    int updateByPrimaryKey(SysGroup record);
    
    // 查询
 	List<SysGroup> findPageBreakByCondition(
 			@Param("keywords") String keywords,
 			@Param("orgType") String orgType,RowBounds rb);
 	
 	Integer findNumberByCondition(
 			@Param("keywords") String keywords,
 			@Param("orgType") String orgType);
}