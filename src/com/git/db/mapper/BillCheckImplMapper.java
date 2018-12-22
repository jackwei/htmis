package com.git.db.mapper;

import com.git.db.beans.BillCheckImpl;
import com.git.db.beans.BillCheckImplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BillCheckImplMapper {
    int countByExample(BillCheckImplExample example);

    int deleteByExample(BillCheckImplExample example);

    int deleteByPrimaryKey(Long checkId);

    int insert(BillCheckImpl record);

    int insertSelective(BillCheckImpl record);

    List<BillCheckImpl> selectByExampleWithRowbounds(BillCheckImplExample example, RowBounds rowBounds);

    List<BillCheckImpl> selectByExample(BillCheckImplExample example);

    BillCheckImpl selectByPrimaryKey(Long checkId);

    int updateByExampleSelective(@Param("record") BillCheckImpl record, @Param("example") BillCheckImplExample example);

    int updateByExample(@Param("record") BillCheckImpl record, @Param("example") BillCheckImplExample example);

    int updateByPrimaryKeySelective(BillCheckImpl record);

    int updateByPrimaryKey(BillCheckImpl record);
}