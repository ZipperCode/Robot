package org.chat.service;

import org.apache.ibatis.javassist.compiler.ast.Keyword;
import org.chat.bean.vo.KeyWord;
import org.chat.bean.vo.Question;

import java.util.List;
import java.util.Set;

/**
 * @author zzp
 * @date 2020/2/25
 */

public interface IKeyWordService {

    int add(KeyWord keyWord);

    int update(KeyWord keyWord);

    /**
     * 关键词引用加一
     * @param keywordId
     * @return
     */
    int incKeywordCountTimes(Integer keywordId);

    /**
     * 根据问题id进行关键字计数
     * @param questionId
     * @return
     */
    int incKeywordCountTimesByQuestionId(Integer questionId);

    /**
     * 查找关键词
     * @return
     */
    List<KeyWord> keyWord();

    /**
     * 查询的到关键词表与
     * @param keyWord
     * @return
     */
    Set<Integer> findQuestionId(Set<String> keyWord);

    /**
     * 查找关键匹配的关键词列表
     * @param keyword
     * @return
     */
    Set<KeyWord> findKeywords(Set<String> keyword);

    /**
     * 通过keyWord的id查询对应的问题id
     * @param keyWordIds
     * @return
     */
    List<Question> findQuestionByKeyWords(Set<Integer> keyWordIds);
}
