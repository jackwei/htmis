package com.git.db.mapper;

import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.CaseClaimImplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CaseClaimImplMapper {
    int countByExample(CaseClaimImplExample example);

    int deleteByExample(CaseClaimImplExample example);

    int deleteByPrimaryKey(Long claimId);
    
    int deleteByIncomeId(String inComeId);

    int insert(CaseClaimImpl record);

    int insertSelective(CaseClaimImpl record);

    List<CaseClaimImpl> selectByExampleWithRowbounds(CaseClaimImplExample example, RowBounds rowBounds);

    List<CaseClaimImpl> selectByExample(CaseClaimImplExample example);

    CaseClaimImpl selectByPrimaryKey(Long claimId);

    int updateByExampleSelective(@Param("record") CaseClaimImpl record, @Param("example") CaseClaimImplExample example);

    int updateByExample(@Param("record") CaseClaimImpl record, @Param("example") CaseClaimImplExample example);

    int updateByPrimaryKeySelective(CaseClaimImpl record);

    int updateByPrimaryKey(CaseClaimImpl record);
    
    CaseClaimImpl searchcaseClaimByIncomeId(String incomeId);
}