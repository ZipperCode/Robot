package org.chat.dao;

import org.apache.ibatis.annotations.*;
import org.chat.bean.vo.Common;
import org.chat.bean.vo.Question;

import java.util.List;

@Mapper
public interface CommonMapper {

    @Insert({"insert into common ",
            "(question, answer, count_times, answer, create_time, update_time)",
            " values (#{question}, #{split}, #{countTimes}, #{answer}, #{createTime}, #{updateTime)"})
    int insert(Common model);

    @Update({"update question set question = #{question}, split = #{split},",
            "word_weight = #{wordWeight}, count_times = #{countTimes},",
            "answer = #{answer}, update_time = #{updateTime}"})
    int update(Common model);

    @Select("select * from common where id = #{id}")
    @ResultMap("org.chat.dao.CommonMapper.BaseResultMap")
    Question findById(Integer id);

    @Select("select * from common where question like %#{keyword}%")
    Question findByKeyword(String keyword);

    @Select("select * from question")
    List<Question> list();


    List<Common> getCommonQuestion();

}
