package com.git.db.mapper;

import com.git.db.beans.TblApplyInfos;
import com.git.db.beans.TblApplyInfosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblApplyInfosMapper {
    int countByExample(TblApplyInfosExample example);

    int deleteByExample(TblApplyInfosExample example);

    int deleteByPrimaryKey(Long oid);

    int insert(TblApplyInfos record);

    int insertSelective(TblApplyInfos record);

    List<TblApplyInfos> selectByExample(TblApplyInfosExample example);

    List<TblApplyInfos> selectByCondition(Long parentId);
    
    TblApplyInfos selectByParentId(Long parentId);
    
    TblApplyInfos selectByPrimaryKey(Long oid);

    int updateByExampleSelective(@Param("record") TblApplyInfos record, @Param("example") TblApplyInfosExample example);

    int updateByExample(@Param("record") TblApplyInfos record, @Param("example") TblApplyInfosExample example);

    int updateByPrimaryKeySelective(TblApplyInfos record);

    int updateByPrimaryKey(TblApplyInfos record);
}