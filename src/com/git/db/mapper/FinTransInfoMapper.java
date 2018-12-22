package com.git.db.mapper;

import com.git.db.beans.FinTransInfo;
import com.git.db.beans.FinTransInfoExample;
import com.git.db.beans.FinTransInfoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FinTransInfoMapper {
    int countByExample(FinTransInfoExample example);

    int deleteByExample(FinTransInfoExample example);

    int deleteByPrimaryKey(FinTransInfoKey key);

    int insert(FinTransInfo record);

    int insertSelective(FinTransInfo record);

    List<FinTransInfo> selectByExampleWithBLOBsWithRowbounds(FinTransInfoExample example, RowBounds rowBounds);

    List<FinTransInfo> selectByExampleWithBLOBs(FinTransInfoExample example);

    List<FinTransInfo> selectByExampleWithRowbounds(FinTransInfoExample example, RowBounds rowBounds);

    List<FinTransInfo> selectByExample(FinTransInfoExample example);

    FinTransInfo selectByPrimaryKey(FinTransInfoKey key);

    int updateByExampleSelective(@Param("record") FinTransInfo record, @Param("example") FinTransInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") FinTransInfo record, @Param("example") FinTransInfoExample example);

    int updateByExample(@Param("record") FinTransInfo record, @Param("example") FinTransInfoExample example);

    int updateByPrimaryKeySelective(FinTransInfo record);

    int updateByPrimaryKeyWithBLOBs(FinTransInfo record);

    int updateByPrimaryKey(FinTransInfo record);
}