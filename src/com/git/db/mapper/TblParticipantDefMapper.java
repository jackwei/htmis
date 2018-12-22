package com.git.db.mapper;

import com.git.db.beans.TblParticipantDef;
import com.git.db.beans.TblParticipantDefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblParticipantDefMapper {
    int countByExample(TblParticipantDefExample example);

    int deleteByExample(TblParticipantDefExample example);

    int deleteByPrimaryKey(Long particDefId);

    int deleteByActivityId(TblParticipantDef tblParticipantDef);
    
    int insert(TblParticipantDef record);

    int insertSelective(TblParticipantDef record);

    List<TblParticipantDef> selectByExample(TblParticipantDefExample example);

    TblParticipantDef selectByPrimaryKey(Long particDefId);

    int updateByExampleSelective(@Param("record") TblParticipantDef record, @Param("example") TblParticipantDefExample example);

    int updateByExample(@Param("record") TblParticipantDef record, @Param("example") TblParticipantDefExample example);

    int updateByPrimaryKeySelective(TblParticipantDef record);

    int updateByPrimaryKey(TblParticipantDef record);
    
    List<TblParticipantDef> selectByActivityDefId(TblParticipantDef tblParticipantDef);
}