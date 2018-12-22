package com.git.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.git.db.beans.SysDictEntry;
import com.git.db.beans.SysDictEntryExample;
import com.git.db.beans.SysDictEntryKey;

public interface SysDictEntryMapper {
    int countByExample(SysDictEntryExample example);

	int deleteByExample(SysDictEntryExample example);

	int deleteByPrimaryKey(SysDictEntryKey key);

	int insert(SysDictEntry record);

	int insertSelective(SysDictEntry record);

	List<SysDictEntry> selectByExample(SysDictEntryExample example);

	SysDictEntry selectByPrimaryKey(SysDictEntryKey key);

	SysDictEntry selectByCondition(SysDictEntry record);
	
	int updateByExampleSelective(@Param("record") SysDictEntry record,
			@Param("example") SysDictEntryExample example);

	int updateByExample(@Param("record") SysDictEntry record,
			@Param("example") SysDictEntryExample example);

	int updateByPrimaryKeySelective(SysDictEntry record);

	int updateByPrimaryKey(SysDictEntry record);
	    
    List getDictEntryByTypeId(@Param("dicttypeid") String dictTypeId);
    List getDictEntryByParentId(@Param("dicttypeid") String dictTypeId,@Param("parentdictid") String parentDictId);
}