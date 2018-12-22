package com.git.db.mapper;

import com.git.db.beans.TblParams;
import com.git.db.beans.TblParamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TblParamsMapper {
    int countByExample(TblParamsExample example);

    int deleteByExample(TblParamsExample example);

    int deleteByPrimaryKey(Long oid);

    int insert(TblParams record);

    int insertSelective(TblParams record);

    List<TblParams> selectByExample(TblParamsExample example, RowBounds rb);

    TblParams selectByPrimaryKey(Long oid);

    int updateByExampleSelective(@Param("record") TblParams record, @Param("example") TblParamsExample example);

    int updateByExample(@Param("record") TblParams record, @Param("example") TblParamsExample example);

    int updateByPrimaryKeySelective(TblParams record);

    int updateByPrimaryKey(TblParams record);
    
    List<TblParams> selectByCondition(@Param("keywords") String keywords, RowBounds rb);
    
    int countByCondition(@Param("keywords") String keywords);
}