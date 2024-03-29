package org.chat.dao;

import org.apache.ibatis.annotations.*;
import org.chat.bean.vo.Common;
import org.chat.bean.vo.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommonMapper {

    @Insert({"insert into common ",
            "(question, answer, count_times, answer, create_time, update_time)",
            " values (#{question}, #{split}, #{countTimes}, #{answer}, #{createTime}, #{updateTime)"})
    int insert(Common model);

    @Update({"update common set question = #{question}, ",
            "word_weight = #{wordWeight}, count_times = #{countTimes},",
            "answer = #{answer}, update_time = #{updateTime}"})
    int update(Common model);

    @Update("update common set count_times = count_times + 1 , set update_time = now() where id = #{id}")
    int incCountTimes(Integer id);

    @Select("select count(*) from common")
    long count();

    @Select("select * from common where id = #{id}")
    @ResultMap("org.chat.dao.CommonMapper.BaseResultMap")
    Common findById(Integer id);

    @Select("select * from common where question like %#{keyword}%")
    Common findByKeywordOne(String keyword);

    @Select("select * from question")
    List<Common> list();

    @Select("select * from common where question like %#{keyword}%")
    List<Common> selectByQuestion(String question);

    List<Common> selectByKeyword(String keyword);

}
