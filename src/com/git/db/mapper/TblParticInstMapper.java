package com.git.db.mapper;

import com.git.db.beans.TblParticInst;
import com.git.db.beans.TblParticInstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TblParticInstMapper {
    int countByExample(TblParticInstExample example);

    int deleteByExample(TblParticInstExample example);

    int deleteByPrimaryKey(Long particInstId);

    int deleteByProcessInstId(Long processInstId);
    
    int insert(TblParticInst record);

    int insertSelective(TblParticInst record);

    List<TblParticInst> selectByExampleWithRowbounds(TblParticInstExample example, RowBounds rowBounds);

    List<TblParticInst> selectByExample(TblParticInstExample example);

    TblParticInst selectByPrimaryKey(Long particInstId);

    int updateByExampleSelective(@Param("record") TblParticInst record, @Param("example") TblParticInstExample example);

    int updateByExample(@Param("record") TblParticInst record, @Param("example") TblParticInstExample example);

    int updateByPrimaryKeySelective(TblParticInst record);

    int updateByPrimaryKey(TblParticInst record);
}