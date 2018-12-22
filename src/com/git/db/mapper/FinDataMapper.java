package com.git.db.mapper;

import com.git.db.beans.FinData;
import com.git.db.beans.FinDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FinDataMapper {
    int countByExample(FinDataExample example);

    int deleteByExample(FinDataExample example);

    int deleteByPrimaryKey(String batchNo);

    int insert(FinData record);

    int insertSelective(FinData record);

    List<FinData> selectByExampleWithRowbounds(FinDataExample example, RowBounds rowBounds);

    List<FinData> selectByExample(FinDataExample example);

    FinData selectByPrimaryKey(String batchNo);

    int updateByExampleSelective(@Param("record") FinData record, @Param("example") FinDataExample example);

    int updateByExample(@Param("record") FinData record, @Param("example") FinDataExample example);

    int updateByPrimaryKeySelective(FinData record);

    int updateByPrimaryKey(FinData record);
    
    List<FinData> selectByDealFlag(String dealFlag);
}