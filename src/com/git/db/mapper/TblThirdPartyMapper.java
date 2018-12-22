package com.git.db.mapper;

import com.git.db.beans.TblRewarranter;
import com.git.db.beans.TblThirdParty;
import com.git.db.beans.TblThirdPartyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TblThirdPartyMapper {
    int countByExample(TblThirdPartyExample example);

    int deleteByExample(TblThirdPartyExample example);

    int deleteByPrimaryKey(Long oid);

    int insert(TblThirdParty record);

    int insertSelective(TblThirdParty record);

    List<TblThirdParty> selectByExampleWithRowbounds(TblThirdPartyExample example, RowBounds rowBounds);

    List<TblThirdParty> selectByExample(TblThirdPartyExample example);

    TblThirdParty selectByPrimaryKey(Long oid);

    int updateByExampleSelective(@Param("record") TblThirdParty record, @Param("example") TblThirdPartyExample example);

    int updateByExample(@Param("record") TblThirdParty record, @Param("example") TblThirdPartyExample example);

    int updateByPrimaryKeySelective(TblThirdParty record);

    int updateByPrimaryKey(TblThirdParty record);
    
    List<TblThirdParty> selectByCondition(@Param("keywords") String keywords, RowBounds rb);
    
    int countByCondition(@Param("keywords") String keywords);
}