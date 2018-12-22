package com.git.db.mapper;

import com.git.db.beans.TblProcessDef;
import com.git.db.beans.TblProcessDefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TblProcessDefMapper {
    int countByExample(TblProcessDefExample example);
    
    int deleteByExample(TblProcessDefExample example);

    int deleteByPrimaryKey(Long processDefId);

    int insert(TblProcessDef record);

    int insertSelective(TblProcessDef record);

    List<TblProcessDef> selectByExample(TblProcessDefExample example,RowBounds rb);
 
    List<TblProcessDef> selectByCondition(TblProcessDef tblProcessDef,RowBounds rb);
    
    int countByCondition(TblProcessDef tblProcessDef);
    
    TblProcessDef selectByPrimaryKey(Long processDefId);

    int updateByExampleSelective(@Param("record") TblProcessDef record, @Param("example") TblProcessDefExample example);

    int updateByExample(@Param("record") TblProcessDef record, @Param("example") TblProcessDefExample example);

    int updateByPrimaryKeySelective(TblProcessDef record);

    int updateByPrimaryKey(TblProcessDef record);
}