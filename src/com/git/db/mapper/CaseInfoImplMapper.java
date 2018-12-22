package com.git.db.mapper;

import com.git.db.beans.CaseInfoImpl;
import com.git.db.beans.CaseInfoImplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CaseInfoImplMapper {
    int countByExample(CaseInfoImplExample example);

    int deleteByExample(CaseInfoImplExample example);

    int deleteByPrimaryKey(Long caseId);

    int insert(CaseInfoImpl record);

    int insertSelective(CaseInfoImpl record);

    List<CaseInfoImpl> selectByExampleWithRowbounds(CaseInfoImplExample example, RowBounds rowBounds);

    List<CaseInfoImpl> selectByExample(CaseInfoImplExample example);

    CaseInfoImpl selectByPrimaryKey(Long caseId);

    int updateByExampleSelective(@Param("record") CaseInfoImpl record, @Param("example") CaseInfoImplExample example);

    int updateByExample(@Param("record") CaseInfoImpl record, @Param("example") CaseInfoImplExample example);

    int updateByPrimaryKeySelective(CaseInfoImpl record);

    int updateByPrimaryKey(CaseInfoImpl record);
}