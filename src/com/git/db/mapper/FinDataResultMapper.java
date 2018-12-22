package com.git.db.mapper;

import com.git.db.beans.FinDataResult;
import com.git.db.beans.FinDataResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FinDataResultMapper {
    int countByExample(FinDataResultExample example);

    int deleteByExample(FinDataResultExample example);

    int deleteByPrimaryKey(Long seqId);

    int insert(FinDataResult record);

    int insertSelective(FinDataResult record);

    List<FinDataResult> selectByExampleWithRowbounds(FinDataResultExample example, RowBounds rowBounds);

    List<FinDataResult> selectByExample(FinDataResultExample example);

    FinDataResult selectByPrimaryKey(Long seqId);

    int updateByExampleSelective(@Param("record") FinDataResult record, @Param("example") FinDataResultExample example);

    int updateByExample(@Param("record") FinDataResult record, @Param("example") FinDataResultExample example);

    int updateByPrimaryKeySelective(FinDataResult record);

    int updateByPrimaryKey(FinDataResult record);
    
    List<FinDataResult> selectByDealFlag(String dealFlag);
}