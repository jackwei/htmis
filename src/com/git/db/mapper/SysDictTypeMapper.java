package com.git.db.mapper;

import com.git.db.beans.SysDictType;
import com.git.db.beans.SysDictTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDictTypeMapper {
    int countByExample(SysDictTypeExample example);

    int deleteByExample(SysDictTypeExample example);

    int deleteByPrimaryKey(String dicttypeid);

    int insert(SysDictType record);

    int insertSelective(SysDictType record);

    List<SysDictType> selectByExample(SysDictTypeExample example);

    SysDictType selectByPrimaryKey(String dicttypeid);

    int updateByExampleSelective(@Param("record") SysDictType record, @Param("example") SysDictTypeExample example);

    int updateByExample(@Param("record") SysDictType record, @Param("example") SysDictTypeExample example);

    int updateByPrimaryKeySelective(SysDictType record);

    int updateByPrimaryKey(SysDictType record);
}