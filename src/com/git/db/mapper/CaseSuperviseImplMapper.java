package com.git.db.mapper;

import com.git.db.beans.CaseSuperviseImpl;
import com.git.db.beans.CaseSuperviseImplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CaseSuperviseImplMapper {
    int countByExample(CaseSuperviseImplExample example);

    int deleteByExample(CaseSuperviseImplExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CaseSuperviseImpl record);

    int insertSelective(CaseSuperviseImpl record);

    List<CaseSuperviseImpl> selectByExampleWithRowbounds(CaseSuperviseImplExample example, RowBounds rowBounds);

    List<CaseSuperviseImpl> selectByExample(CaseSuperviseImplExample example);

    CaseSuperviseImpl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CaseSuperviseImpl record, @Param("example") CaseSuperviseImplExample example);

    int updateByExample(@Param("record") CaseSuperviseImpl record, @Param("example") CaseSuperviseImplExample example);

    int updateByPrimaryKeySelective(CaseSuperviseImpl record);

    int updateByPrimaryKey(CaseSuperviseImpl record);
}