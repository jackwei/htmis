package com.git.db.mapper;

import com.git.db.beans.TblProcessInst;
import com.git.db.beans.TblProcessInstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TblProcessInstMapper {
    int countByExample(TblProcessInstExample example);

    int deleteByExample(TblProcessInstExample example);

    int deleteByPrimaryKey(Long processInstId);

    int insert(TblProcessInst record);

    int insertSelective(TblProcessInst record);

    List<TblProcessInst> selectByExampleWithRowbounds(TblProcessInstExample example, RowBounds rowBounds);

    List<TblProcessInst> selectByExample(TblProcessInstExample example);

    TblProcessInst selectByPrimaryKey(Long processInstId);

    int updateByExampleSelective(@Param("record") TblProcessInst record, @Param("example") TblProcessInstExample example);

    int updateByExample(@Param("record") TblProcessInst record, @Param("example") TblProcessInstExample example);

    int updateByPrimaryKeySelective(TblProcessInst record);

    int updateByPrimaryKey(TblProcessInst record);
}