package com.git.db.mapper;

import com.git.db.beans.TblActivityDef;
import com.git.db.beans.TblActivityDefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblActivityDefMapper {
    int countByExample(TblActivityDefExample example);

    int deleteByExample(TblActivityDefExample example);

    int deleteByPrimaryKey(Long activityDefId);

    int insert(TblActivityDef record);

    int insertSelective(TblActivityDef record);

    List<TblActivityDef> selectByExample(TblActivityDefExample example);

    TblActivityDef selectByPrimaryKey(Long activityDefId);
    
    TblActivityDef selectByProcessDefId(Long processDefId);

    int updateByExampleSelective(@Param("record") TblActivityDef record, @Param("example") TblActivityDefExample example);

    int updateByExample(@Param("record") TblActivityDef record, @Param("example") TblActivityDefExample example);

    int updateByPrimaryKeySelective(TblActivityDef record);

    int updateByPrimaryKey(TblActivityDef record);
    
    List<TblActivityDef> selectByProcessId(Long processId);
    
    Long searchMaxId(Long processId);
}