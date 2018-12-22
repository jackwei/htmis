package com.git.db.mapper;

import com.git.db.beans.ConsignorPayImpl;
import com.git.db.beans.ConsignorPayImplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ConsignorPayImplMapper {
    int countByExample(ConsignorPayImplExample example);

    int deleteByExample(ConsignorPayImplExample example);

    int deleteByPrimaryKey(Long payId);

    int insert(ConsignorPayImpl record);

    int insertSelective(ConsignorPayImpl record);

    List<ConsignorPayImpl> selectByExampleWithRowbounds(ConsignorPayImplExample example, RowBounds rowBounds);

    List<ConsignorPayImpl> selectByExample(ConsignorPayImplExample example);

    ConsignorPayImpl selectByPrimaryKey(Long payId);

    int updateByExampleSelective(@Param("record") ConsignorPayImpl record, @Param("example") ConsignorPayImplExample example);

    int updateByExample(@Param("record") ConsignorPayImpl record, @Param("example") ConsignorPayImplExample example);

    int updateByPrimaryKeySelective(ConsignorPayImpl record);

    int updateByPrimaryKey(ConsignorPayImpl record);
}