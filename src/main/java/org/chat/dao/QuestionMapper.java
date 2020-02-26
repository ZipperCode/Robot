package org.chat.dao;

import org.apache.ibatis.annotations.*;
import org.chat.vo.KeyWord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert({"insert into question (question,split,answer,create_time,update_time)",
            " values (#{question}, #{split}, #{answer}, #{createTime}, #{updateTime)"})
    int insert(KeyWord keyWord);

    @Update({"update question set question = #{question}, split = #{split},",
            "answer = #{answer}, update_time = #{updateTime}"})
    int update(KeyWord keyWord);

    @Select("select * from answer where id = #{id}")
    @ResultMap("org.chat.dao.KeyWordMapper.BaseResultMap")
    KeyWord findById(Integer id);

    @Select("select * from key_word")
    List<KeyWord> list();



}
