package com.git.db.mapper;

import com.git.db.beans.CaseBillImpl;
import com.git.db.beans.CaseBillImplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CaseBillImplMapper {
    int countByExample(CaseBillImplExample example);

    int deleteByExample(CaseBillImplExample example);

    int deleteByPrimaryKey(Long billId);

    int insert(CaseBillImpl record);

    int insertSelective(CaseBillImpl record);

    List<CaseBillImpl> selectByExampleWithRowbounds(CaseBillImplExample example, RowBounds rowBounds);

    List<CaseBillImpl> selectByExample(CaseBillImplExample example);

    CaseBillImpl selectByPrimaryKey(Long billId);

    int updateByExampleSelective(@Param("record") CaseBillImpl record, @Param("example") CaseBillImplExample example);

    int updateByExample(@Param("record") CaseBillImpl record, @Param("example") CaseBillImplExample example);

    int updateByPrimaryKeySelective(CaseBillImpl record);

    int updateByPrimaryKey(CaseBillImpl record);
}