package com.git.db.mapper;

import com.git.db.beans.ResChapter;
import com.git.db.beans.ResChapterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResChapterMapper {
    int countByExample(ResChapterExample example);

    int deleteByExample(ResChapterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ResChapter record);

    int insertSelective(ResChapter record);

    List<ResChapter> selectByExampleWithBLOBs(ResChapterExample example);

    List<ResChapter> selectByExample(ResChapterExample example);

    ResChapter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ResChapter record, @Param("example") ResChapterExample example);

    int updateByExampleWithBLOBs(@Param("record") ResChapter record, @Param("example") ResChapterExample example);

    int updateByExample(@Param("record") ResChapter record, @Param("example") ResChapterExample example);

    int updateByPrimaryKeySelective(ResChapter record);

    int updateByPrimaryKeyWithBLOBs(ResChapter record);

    int updateByPrimaryKey(ResChapter record);
}