package com.git.db.mapper;

import com.git.db.beans.BillCheckRecordsImpl;
import com.git.db.beans.BillCheckRecordsImplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BillCheckRecordsImplMapper {
    int countByExample(BillCheckRecordsImplExample example);

    int deleteByExample(BillCheckRecordsImplExample example);

    int deleteByPrimaryKey(Long recordsId);

    int insert(BillCheckRecordsImpl record);

    int insertSelective(BillCheckRecordsImpl record);

    List<BillCheckRecordsImpl> selectByExampleWithRowbounds(BillCheckRecordsImplExample example, RowBounds rowBounds);

    List<BillCheckRecordsImpl> selectByExample(BillCheckRecordsImplExample example);

    BillCheckRecordsImpl selectByPrimaryKey(Long recordsId);

    int updateByExampleSelective(@Param("record") BillCheckRecordsImpl record, @Param("example") BillCheckRecordsImplExample example);

    int updateByExample(@Param("record") BillCheckRecordsImpl record, @Param("example") BillCheckRecordsImplExample example);

    int updateByPrimaryKeySelective(BillCheckRecordsImpl record);

    int updateByPrimaryKey(BillCheckRecordsImpl record);
}