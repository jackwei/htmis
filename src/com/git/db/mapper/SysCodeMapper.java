package com.git.db.mapper;

import com.git.db.beans.SysCode;
import com.git.db.beans.SysCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCodeMapper {
    int countByExample(SysCodeExample example);

    int deleteByExample(SysCodeExample example);

    int deleteByPrimaryKey(String codeid);

    int insert(SysCode record);

    int insertSelective(SysCode record);

    List<SysCode> selectByExample(SysCodeExample example);

    SysCode selectByPrimaryKey(String codeid);

    int updateByExampleSelective(@Param("record") SysCode record, @Param("example") SysCodeExample example);

    int updateByExample(@Param("record") SysCode record, @Param("example") SysCodeExample example);

    int updateByPrimaryKeySelective(SysCode record);

    int updateByPrimaryKey(SysCode record);
}