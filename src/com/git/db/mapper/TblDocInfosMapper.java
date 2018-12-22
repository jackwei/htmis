package com.git.db.mapper;

import com.git.db.beans.TblDocInfos;
import com.git.db.beans.TblDocInfosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblDocInfosMapper {
    int countByExample(TblDocInfosExample example);

    int deleteByExample(TblDocInfosExample example);

    int deleteByPrimaryKey(Long oid);

    int insert(TblDocInfos record);

    int insertSelective(TblDocInfos record);

    List<TblDocInfos> selectByExample(TblDocInfosExample example);
    
    List<TblDocInfos> selectByApplyId(Long applyid);
    
    TblDocInfos selectByPrimaryKey(Long oid);

    int updateByExampleSelective(@Param("record") TblDocInfos record, @Param("example") TblDocInfosExample example);

    int updateByExample(@Param("record") TblDocInfos record, @Param("example") TblDocInfosExample example);

    int updateByPrimaryKeySelective(TblDocInfos record);

    int updateByPrimaryKey(TblDocInfos record);
}