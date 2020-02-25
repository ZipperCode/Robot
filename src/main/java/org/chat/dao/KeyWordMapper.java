package org.chat.dao;

import org.apache.ibatis.annotations.*;
import org.chat.vo.KeyWord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface KeyWordMapper {

    @Insert({"insert into key_word (key_word,word_times,ban,create_time,update_time)",
            " values (#{keyWord},#{word_times},#{ban}, #{createTime}, #{updateTime)"})
    int insert(KeyWord keyWord);

    @Update({"update key_word set key_word = #{keyWord}, word_times = #{wordTimes},",
            "ban = #{ban}, update_time = #{updateTime}"})
    int update(KeyWord keyWord);

    @Select("select * from key_word where id = #{id}")
    @ResultMap("org.chat.dao.KeyWordMapper.BaseResultMap")
    KeyWord findById(Integer id);

    @Select("select * from key_word")
    List<KeyWord> list();



}
