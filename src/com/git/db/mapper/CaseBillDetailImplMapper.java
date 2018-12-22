package com.git.db.mapper;

import com.git.db.beans.CaseBillDetailImpl;
import com.git.db.beans.CaseBillDetailImplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CaseBillDetailImplMapper {
    int countByExample(CaseBillDetailImplExample example);

    int deleteByExample(CaseBillDetailImplExample example);

    int deleteByPrimaryKey(Long detailId);

    int insert(CaseBillDetailImpl record);

    int insertSelective(CaseBillDetailImpl record);

    List<CaseBillDetailImpl> selectByExampleWithRowbounds(CaseBillDetailImplExample example, RowBounds rowBounds);

    List<CaseBillDetailImpl> selectByExample(CaseBillDetailImplExample example);

    CaseBillDetailImpl selectByPrimaryKey(Long detailId);
    
    CaseBillDetailImpl selectByConsignorid(Long consignorid);
    
    int updateByExampleSelective(@Param("record") CaseBillDetailImpl record, @Param("example") CaseBillDetailImplExample example);

    int updateByExample(@Param("record") CaseBillDetailImpl record, @Param("example") CaseBillDetailImplExample example);

    int updateByPrimaryKeySelective(CaseBillDetailImpl record);

    int updateByPrimaryKey(CaseBillDetailImpl record);
}