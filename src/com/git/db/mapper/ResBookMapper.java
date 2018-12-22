package com.git.db.mapper;

import com.git.db.beans.ResBook;
import com.git.db.beans.ResBookExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ResBookMapper {
    int countByExample(ResBookExample example);

    int deleteByExample(ResBookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ResBook record);

    int insertSelective(ResBook record);

    List<ResBook> selectByCondition(
			@Param("keywords") String keywords, RowBounds rb);
    
    int countByCondition(@Param("keywords") String keywords);
    
    List<ResBook> selectByExample(ResBookExample example);

    ResBook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ResBook record, @Param("example") ResBookExample example);

    int updateByExample(@Param("record") ResBook record, @Param("example") ResBookExample example);

    int updateByPrimaryKeySelective(ResBook record);

    int updateByPrimaryKey(ResBook record);
}