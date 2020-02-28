package org.chat.dao;

import org.apache.ibatis.annotations.*;
import org.chat.bean.vo.KeyWord;
import org.chat.bean.vo.Question;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Mapper
@Repository
public interface KeyWordMapper {

    @Insert({"insert into keyword (keyword,word_times,ban,create_time,update_time)",
            " values (#{keyword},#{word_times},#{ban}, #{createTime}, #{updateTime)"})
    int insert(KeyWord keyWord);

    @Update({"update key_word set keyword = #{keyword}, word_times = #{wordTimes},",
            "ban = #{ban}, update_time = #{updateTime}"})
    int update(KeyWord keyWord);

    @Update("update keyword set count_times = count_times + 1 , set update_time = now() where id = #{id}")
    int incCountKeyword(Integer keywordId);

    @Select("select count(*) from keyword")
    @ResultType(Long.class)
    Long count();

    int incCountTimesByQuestionId(Integer questionId);

    int incQuestionCountTimesByKeywordId(Integer keywordId);

    @Select("select * from keyword where id = #{id}")
    @ResultMap("org.chat.dao.KeyWordMapper.BaseResultMap")
    KeyWord findById(Integer id);

    @Select("select * from keyword")
    @ResultMap("org.chat.dao.KeyWordMapper.BaseResultMap")
    List<KeyWord> list();

    Set<Integer> selectQuestionIdByKeyword(String keyword);

    List<Integer> selectQuestionIdByKeywordSet(Set<String> keyWords);

    List<Question> selectQuestionByKeywordIds(Set<Integer> keywordIds);



}
