package com.git.db.mapper;

import com.git.db.beans.TblActivityInst;
import com.git.db.beans.TblActivityInstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TblActivityInstMapper {
    int countByExample(TblActivityInstExample example);

    int deleteByExample(TblActivityInstExample example);

    int deleteByPrimaryKey(Long activityInstId);
    
    int deleteByProcessInstId(Long processInstId);
    
    int insert(TblActivityInst record);

    int insertSelective(TblActivityInst record);

    List<TblActivityInst> selectByExampleWithRowbounds(TblActivityInstExample example, RowBounds rowBounds);

    List<TblActivityInst> selectByExample(TblActivityInstExample example);

    TblActivityInst selectByPrimaryKey(Long activityInstId);

    int updateByExampleSelective(@Param("record") TblActivityInst record, @Param("example") TblActivityInstExample example);

    int updateByExample(@Param("record") TblActivityInst record, @Param("example") TblActivityInstExample example);

    int updateByPrimaryKeySelective(TblActivityInst record);

    int updateByPrimaryKey(TblActivityInst record);
}