package com.git.db.mapper;

import com.git.db.beans.TblConsignor;
import com.git.db.beans.TblConsignorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TblConsignorMapper {
    int countByExample(TblConsignorExample example);

    int deleteByExample(TblConsignorExample example);

    int deleteByPrimaryKey(Long oid);

    int insert(TblConsignor record);

    int insertSelective(TblConsignor record);

    List<TblConsignor> selectByExampleWithRowbounds(TblConsignorExample example, RowBounds rowBounds);

    List<TblConsignor> selectByExample(TblConsignorExample example);

    TblConsignor selectByPrimaryKey(Long oid);

    int updateByExampleSelective(@Param("record") TblConsignor record, @Param("example") TblConsignorExample example);

    int updateByExample(@Param("record") TblConsignor record, @Param("example") TblConsignorExample example);

    int updateByPrimaryKeySelective(TblConsignor record);

    int updateByPrimaryKey(TblConsignor record);
}