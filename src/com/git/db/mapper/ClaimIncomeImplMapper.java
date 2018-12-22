package com.git.db.mapper;

import com.git.db.beans.ClaimIncomeImpl;
import com.git.db.beans.ClaimIncomeImplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ClaimIncomeImplMapper {
    int countByExample(ClaimIncomeImplExample example);

    int deleteByExample(ClaimIncomeImplExample example);

    int deleteByPrimaryKey(Long incomeId);

    int insert(ClaimIncomeImpl record);

    int insertSelective(ClaimIncomeImpl record);

    List<ClaimIncomeImpl> selectByExampleWithRowbounds(ClaimIncomeImplExample example, RowBounds rowBounds);

    List<ClaimIncomeImpl> selectByExample(ClaimIncomeImplExample example);

    ClaimIncomeImpl selectByPrimaryKey(Long incomeId);

    int updateByExampleSelective(@Param("record") ClaimIncomeImpl record, @Param("example") ClaimIncomeImplExample example);

    int updateByExample(@Param("record") ClaimIncomeImpl record, @Param("example") ClaimIncomeImplExample example);

    int updateByPrimaryKeySelective(ClaimIncomeImpl record);

    int updateByPrimaryKey(ClaimIncomeImpl record);
}