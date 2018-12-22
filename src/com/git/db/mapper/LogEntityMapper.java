package com.git.db.mapper;

import com.git.db.beans.LogEntity;
import com.git.db.beans.LogEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LogEntityMapper {
    int countByExample(LogEntityExample example);

    int deleteByExample(LogEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LogEntity record);

    int insertSelective(LogEntity record);

    List<LogEntity> selectByExampleWithRowbounds(LogEntityExample example, RowBounds rowBounds);

    List<LogEntity> selectByExample(LogEntityExample example);

    LogEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LogEntity record, @Param("example") LogEntityExample example);

    int updateByExample(@Param("record") LogEntity record, @Param("example") LogEntityExample example);

    int updateByPrimaryKeySelective(LogEntity record);

    int updateByPrimaryKey(LogEntity record);
}