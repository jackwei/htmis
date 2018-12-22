package com.git.db.mapper;

import com.git.db.beans.ClaimRateSubImpl;
import com.git.db.beans.ClaimRateSubImplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ClaimRateSubImplMapper {
    int countByExample(ClaimRateSubImplExample example);

    int deleteByExample(ClaimRateSubImplExample example);

    int deleteByPrimaryKey(Long rateId);

    int insert(ClaimRateSubImpl record);

    int insertSelective(ClaimRateSubImpl record);

    List<ClaimRateSubImpl> selectByExampleWithRowbounds(ClaimRateSubImplExample example, RowBounds rowBounds);

    List<ClaimRateSubImpl> selectByExample(ClaimRateSubImplExample example);

    ClaimRateSubImpl selectByPrimaryKey(Long rateId);

    int updateByExampleSelective(@Param("record") ClaimRateSubImpl record, @Param("example") ClaimRateSubImplExample example);

    int updateByExample(@Param("record") ClaimRateSubImpl record, @Param("example") ClaimRateSubImplExample example);

    int updateByPrimaryKeySelective(ClaimRateSubImpl record);

    int updateByPrimaryKey(ClaimRateSubImpl record);
}