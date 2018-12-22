package com.git.db.mapper;

import com.git.db.beans.TblPassurePayMents;
import com.git.db.beans.TblPassurePayMentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TblPassurePayMentsMapper {
    int countByExample(TblPassurePayMentsExample example);

    int deleteByExample(TblPassurePayMentsExample example);

    int deleteByPrimaryKey(Long passurepayid);

    int insert(TblPassurePayMents record);

    int insertSelective(TblPassurePayMents record);

    List<TblPassurePayMents> selectByExampleWithRowbounds(TblPassurePayMentsExample example, RowBounds rowBounds);

    List<TblPassurePayMents> selectByExample(TblPassurePayMentsExample example);

    TblPassurePayMents selectByPrimaryKey(Long passurepayid);

    int updateByExampleSelective(@Param("record") TblPassurePayMents record, @Param("example") TblPassurePayMentsExample example);

    int updateByExample(@Param("record") TblPassurePayMents record, @Param("example") TblPassurePayMentsExample example);

    int updateByPrimaryKeySelective(TblPassurePayMents record);

    int updateByPrimaryKey(TblPassurePayMents record);
}