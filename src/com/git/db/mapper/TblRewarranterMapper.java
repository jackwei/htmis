package com.git.db.mapper;

import com.git.db.beans.TblRewarranter;
import com.git.db.beans.TblRewarranterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TblRewarranterMapper {
    int countByExample(TblRewarranterExample example);

    int deleteByExample(TblRewarranterExample example);

    int deleteByPrimaryKey(Long oid);

    int insert(TblRewarranter record);

    int insertSelective(TblRewarranter record);

    List<TblRewarranter> selectByExampleWithRowbounds(TblRewarranterExample example, RowBounds rowBounds);

    List<TblRewarranter> selectByExample(TblRewarranterExample example);

    TblRewarranter selectByPrimaryKey(Long oid);

    int updateByExampleSelective(@Param("record") TblRewarranter record, @Param("example") TblRewarranterExample example);

    int updateByExample(@Param("record") TblRewarranter record, @Param("example") TblRewarranterExample example);

    int updateByPrimaryKeySelective(TblRewarranter record);

    int updateByPrimaryKey(TblRewarranter record);
}