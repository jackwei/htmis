package com.git.db.mapper;

import com.git.db.beans.CaseHandleImpl;
import com.git.db.beans.CaseHandleImplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CaseHandleImplMapper {
    int countByExample(CaseHandleImplExample example);

    int deleteByExample(CaseHandleImplExample example);

    int deleteByPrimaryKey(Long seqId);

    int insert(CaseHandleImpl record);

    int insertSelective(CaseHandleImpl record);

    List<CaseHandleImpl> selectByExampleWithRowbounds(CaseHandleImplExample example, RowBounds rowBounds);

    List<CaseHandleImpl> selectByExample(CaseHandleImplExample example);

    CaseHandleImpl selectByPrimaryKey(Long seqId);

    int updateByExampleSelective(@Param("record") CaseHandleImpl record, @Param("example") CaseHandleImplExample example);

    int updateByExample(@Param("record") CaseHandleImpl record, @Param("example") CaseHandleImplExample example);

    int updateByPrimaryKeySelective(CaseHandleImpl record);

    int updateByPrimaryKey(CaseHandleImpl record);
}