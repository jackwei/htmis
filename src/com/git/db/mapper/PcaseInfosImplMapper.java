package com.git.db.mapper;

import com.git.db.beans.PcaseInfosImpl;
import com.git.db.beans.PcaseInfosImplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PcaseInfosImplMapper {
    int countByExample(PcaseInfosImplExample example);

    int deleteByExample(PcaseInfosImplExample example);

    int deleteByPrimaryKey(String oid);

    int insert(PcaseInfosImpl record);

    int insertSelective(PcaseInfosImpl record);

    List<PcaseInfosImpl> selectByExample(PcaseInfosImplExample example);

    PcaseInfosImpl selectByPrimaryKey(String oid);

    int updateByExampleSelective(@Param("record") PcaseInfosImpl record, @Param("example") PcaseInfosImplExample example);

    int updateByExample(@Param("record") PcaseInfosImpl record, @Param("example") PcaseInfosImplExample example);

    int updateByPrimaryKeySelective(PcaseInfosImpl record);

    int updateByPrimaryKey(PcaseInfosImpl record);
}