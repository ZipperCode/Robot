package org.chat.dao;

import org.apache.ibatis.annotations.*;
import org.chat.bean.vo.Common;
import org.chat.bean.vo.Question;
import org.chat.bean.vo.UnAnsweredQuestion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UnAnsweredQuestionMapper {

    @Insert({"insert into unanswered ",
            "(question, split, word_weight, count_times)",
            " values (#{question}, #{split}, #{wordWeight} ,#{countTimes}"})
    int insert(Question model);

    @Update({"update unanswered set question = #{question}, split = #{split},",
            "word_weight = #{wordWeight}, count_times = #{countTimes},",
            "update_time = #{updateTime}"})
    int update(Question model);

    int incCountTimes(Integer id);

    @Select("select * from question where id = #{id}")
    @ResultMap("org.chat.dao.QuestionMapper.BaseResultMap")
    UnAnsweredQuestion findById(Integer id);

    @Select("select * from unanswered")
    List<UnAnsweredQuestion> list();

    List<UnAnsweredQuestion> getCommonQuestion();

}
