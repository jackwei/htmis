package com.git.db.mapper;

import com.git.db.beans.SysSequence;
import com.git.db.beans.SysSequenceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSequenceMapper {
    int countByExample(SysSequenceExample example);

    int deleteByExample(SysSequenceExample example);

    int deleteByPrimaryKey(String seqName);

    int insert(SysSequence record);

    int insertSelective(SysSequence record);

    List<SysSequence> selectByExample(SysSequenceExample example);

    SysSequence selectByPrimaryKey(String seqName);

    int updateByExampleSelective(@Param("record") SysSequence record, @Param("example") SysSequenceExample example);

    int updateByExample(@Param("record") SysSequence record, @Param("example") SysSequenceExample example);

    int updateByPrimaryKeySelective(SysSequence record);

    int updateByPrimaryKey(SysSequence record);
}