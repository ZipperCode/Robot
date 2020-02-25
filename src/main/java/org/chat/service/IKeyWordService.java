package org.chat.service;

import org.chat.vo.KeyWord;
import org.chat.vo.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zzp
 * @date 2020/2/25
 */
@Service
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
