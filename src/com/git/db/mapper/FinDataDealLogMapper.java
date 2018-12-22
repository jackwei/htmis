package com.git.db.mapper;

import com.git.db.beans.FinDataDealLog;
import com.git.db.beans.FinDataDealLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FinDataDealLogMapper {
    int countByExample(FinDataDealLogExample example);

    int deleteByExample(FinDataDealLogExample example);

    int deleteByPrimaryKey(Long logId);

    int insert(FinDataDealLog record);

    int insertSelective(FinDataDealLog record);

    List<FinDataDealLog> selectByExampleWithBLOBsWithRowbounds(FinDataDealLogExample example, RowBounds rowBounds);

    List<FinDataDealLog> selectByExampleWithBLOBs(FinDataDealLogExample example);

    List<FinDataDealLog> selectByExampleWithRowbounds(FinDataDealLogExample example, RowBounds rowBounds);

    List<FinDataDealLog> selectByExample(FinDataDealLogExample example);

    FinDataDealLog selectByPrimaryKey(Long logId);

    int updateByExampleSelective(@Param("record") FinDataDealLog record, @Param("example") FinDataDealLogExample example);

    int updateByExampleWithBLOBs(@Param("record") FinDataDealLog record, @Param("example") FinDataDealLogExample example);

    int updateByExample(@Param("record") FinDataDealLog record, @Param("example") FinDataDealLogExample example);

    int updateByPrimaryKeySelective(FinDataDealLog record);

    int updateByPrimaryKeyWithBLOBs(FinDataDealLog record);

    int updateByPrimaryKey(FinDataDealLog record);
}