package com.git.db.mapper;

import com.git.db.beans.BillHangImpl;
import com.git.db.beans.BillHangImplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BillHangImplMapper {
    int countByExample(BillHangImplExample example);

    int deleteByExample(BillHangImplExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BillHangImpl record);

    int insertSelective(BillHangImpl record);

    List<BillHangImpl> selectByExampleWithRowbounds(BillHangImplExample example, RowBounds rowBounds);

    List<BillHangImpl> selectByExample(BillHangImplExample example);

    BillHangImpl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BillHangImpl record, @Param("example") BillHangImplExample example);

    int updateByExample(@Param("record") BillHangImpl record, @Param("example") BillHangImplExample example);

    int updateByPrimaryKeySelective(BillHangImpl record);

    int updateByPrimaryKey(BillHangImpl record);
}