package org.chat.service;

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
     * 查找关键词
     * @return
     */
    List<KeyWord> keyWord();

    Set<Integer> findKeyWord(Set<String> keyWord);


    /**
     * 通过keyWord 的id查询对应的问题
     * @param keyWordIds
     * @return
     */
    List<Question> findQuestionByKeyWords(Set<Integer> keyWordIds);
}
