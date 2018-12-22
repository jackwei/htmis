package com.git.db.mapper;

import com.git.db.beans.ClaimInComeDetailImpl;
import com.git.db.beans.ClaimInComeDetailImplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ClaimInComeDetailImplMapper {
    int countByExample(ClaimInComeDetailImplExample example);

    int deleteByExample(ClaimInComeDetailImplExample example);

    int deleteByPrimaryKey(Long detailId);

    int insert(ClaimInComeDetailImpl record);

    int insertSelective(ClaimInComeDetailImpl record);

    List<ClaimInComeDetailImpl> selectByExampleWithRowbounds(ClaimInComeDetailImplExample example, RowBounds rowBounds);

    List<ClaimInComeDetailImpl> selectByExample(ClaimInComeDetailImplExample example);

    ClaimInComeDetailImpl selectByPrimaryKey(Long detailId);

    int updateByExampleSelective(@Param("record") ClaimInComeDetailImpl record, @Param("example") ClaimInComeDetailImplExample example);

    int updateByExample(@Param("record") ClaimInComeDetailImpl record, @Param("example") ClaimInComeDetailImplExample example);

    int updateByPrimaryKeySelective(ClaimInComeDetailImpl record);

    int updateByPrimaryKey(ClaimInComeDetailImpl record);
}