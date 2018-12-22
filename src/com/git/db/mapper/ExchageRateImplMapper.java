package com.git.db.mapper;

import com.git.db.beans.ExchageRateImpl;
import com.git.db.beans.ExchageRateImplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ExchageRateImplMapper {
    int countByExample(ExchageRateImplExample example);

    int deleteByExample(ExchageRateImplExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExchageRateImpl record);

    int insertSelective(ExchageRateImpl record);

    List<ExchageRateImpl> selectByExampleWithRowbounds(ExchageRateImplExample example, RowBounds rowBounds);

    List<ExchageRateImpl> selectByExample(ExchageRateImplExample example);

    ExchageRateImpl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExchageRateImpl record, @Param("example") ExchageRateImplExample example);

    int updateByExample(@Param("record") ExchageRateImpl record, @Param("example") ExchageRateImplExample example);

    int updateByPrimaryKeySelective(ExchageRateImpl record);

    int updateByPrimaryKey(ExchageRateImpl record);
}