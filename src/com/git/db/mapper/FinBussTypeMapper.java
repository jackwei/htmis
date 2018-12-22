package com.git.db.mapper;

import com.git.db.beans.FinBussType;
import com.git.db.beans.FinBussTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FinBussTypeMapper {
    int countByExample(FinBussTypeExample example);

    int deleteByExample(FinBussTypeExample example);

    int deleteByPrimaryKey(String bussId);

    int insert(FinBussType record);

    int insertSelective(FinBussType record);

    List<FinBussType> selectByExampleWithBLOBsWithRowbounds(FinBussTypeExample example, RowBounds rowBounds);

    List<FinBussType> selectByExampleWithBLOBs(FinBussTypeExample example);

    List<FinBussType> selectByExampleWithRowbounds(FinBussTypeExample example, RowBounds rowBounds);

    List<FinBussType> selectByExample(FinBussTypeExample example);

    FinBussType selectByPrimaryKey(String bussId);

    int updateByExampleSelective(@Param("record") FinBussType record, @Param("example") FinBussTypeExample example);

    int updateByExampleWithBLOBs(@Param("record") FinBussType record, @Param("example") FinBussTypeExample example);

    int updateByExample(@Param("record") FinBussType record, @Param("example") FinBussTypeExample example);

    int updateByPrimaryKeySelective(FinBussType record);

    int updateByPrimaryKeyWithBLOBs(FinBussType record);

    int updateByPrimaryKey(FinBussType record);
}