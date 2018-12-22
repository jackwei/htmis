package com.git.db.mapper;

import com.git.db.beans.BillIncomeImpl;
import com.git.db.beans.BillIncomeImplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BillIncomeImplMapper {
    int countByExample(BillIncomeImplExample example);

    int deleteByExample(BillIncomeImplExample example);

    int deleteByPrimaryKey(Long incomeId);

    int insert(BillIncomeImpl record);

    int insertSelective(BillIncomeImpl record);

    List<BillIncomeImpl> selectByExampleWithRowbounds(BillIncomeImplExample example, RowBounds rowBounds);

    List<BillIncomeImpl> selectByExample(BillIncomeImplExample example);

    BillIncomeImpl selectByPrimaryKey(Long incomeId);

    int updateByExampleSelective(@Param("record") BillIncomeImpl record, @Param("example") BillIncomeImplExample example);

    int updateByExample(@Param("record") BillIncomeImpl record, @Param("example") BillIncomeImplExample example);

    int updateByPrimaryKeySelective(BillIncomeImpl record);

    int updateByPrimaryKey(BillIncomeImpl record);
}