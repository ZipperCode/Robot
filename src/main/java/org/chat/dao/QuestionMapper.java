package org.chat.dao;

import org.apache.ibatis.annotations.*;
import org.chat.bean.vo.Common;
import org.chat.bean.vo.KeyWord;
import org.chat.bean.vo.Question;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert({"insert into question ",
            "(question, split, word_weight, count_times, answer, create_time, update_time)",
            " values (#{question}, #{split}, #{wordWeight},#{countTimes}, #{answer}, #{createTime}, #{updateTime)"})
    int insert(Question model);

    @Update({"update question set question = #{question}, split = #{split},",
            "word_weight = #{wordWeight}, count_times = #{countTimes},",
            "answer = #{answer}, update_time = #{updateTime}"})
    int update(Question model);

    @Select("select * from question where id = #{id}")
    @ResultMap("org.chat.dao.QuestionMapper.BaseResultMap")
    Question findById(Integer id);

    @Select("select * from question")
    List<Question> list();


    List<Common> getCommonQuestion();

}
