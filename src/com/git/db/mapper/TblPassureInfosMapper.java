package com.git.db.mapper;

import com.git.db.beans.TblPassureInfos;
import com.git.db.beans.TblPassureInfosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TblPassureInfosMapper {
    int countByExample(TblPassureInfosExample example);

    int deleteByExample(TblPassureInfosExample example);

    int deleteByPrimaryKey(Long passureid);

    int insert(TblPassureInfos record);

    int insertSelective(TblPassureInfos record);

    List<TblPassureInfos> selectByExampleWithRowbounds(TblPassureInfosExample example, RowBounds rowBounds);

    List<TblPassureInfos> selectByExample(TblPassureInfosExample example);

    TblPassureInfos selectByPrimaryKey(Long passureid);

    int updateByExampleSelective(@Param("record") TblPassureInfos record, @Param("example") TblPassureInfosExample example);

    int updateByExample(@Param("record") TblPassureInfos record, @Param("example") TblPassureInfosExample example);

    int updateByPrimaryKeySelective(TblPassureInfos record);

    int updateByPrimaryKey(TblPassureInfos record);
}