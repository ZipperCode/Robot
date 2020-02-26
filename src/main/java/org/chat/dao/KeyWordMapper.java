package org.chat.dao;

import org.apache.ibatis.annotations.*;
import org.chat.bean.vo.KeyWord;

import java.util.List;

@Mapper
public interface KeyWordMapper {

    @Insert({"insert into keyword (keyword,word_times,ban,create_time,update_time)",
            " values (#{keyword},#{word_times},#{ban}, #{createTime}, #{updateTime)"})
    int insert(KeyWord keyWord);

    @Update({"update key_word set keyword = #{keyword}, word_times = #{wordTimes},",
            "ban = #{ban}, update_time = #{updateTime}"})
    int update(KeyWord keyWord);

    @Select("select * from keyword where id = #{id}")
    @ResultMap("org.chat.dao.KeyWordMapper.BaseResultMap")
    KeyWord findById(Integer id);

    @Select("select * from keyword")
    @ResultMap("org.chat.dao.KeyWordMapper.BaseResultMap")
    List<KeyWord> list();

    @Select("select count(*) from keyword")
    @ResultType(Long.class)
    Long count();



}
