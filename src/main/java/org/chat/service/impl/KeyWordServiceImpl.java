package org.chat.service.impl;

import org.chat.dao.KeyWordMapper;
import org.chat.service.IKeyWordService;
import org.chat.bean.vo.KeyWord;
import org.chat.bean.vo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author zzp
 * @date 2020/2/26
 */
@Service
public class KeyWordServiceImpl implements IKeyWordService {

    @Autowired
    private KeyWordMapper keyWordMapper;

    @Override
    public int add(KeyWord keyWord) {
        return this.keyWordMapper.insert(keyWord);
    }

    @Override
    public int update(KeyWord keyWord) {
        return this.keyWordMapper.update(keyWord);
    }

    @Override
    public int incKeywordCountTimes(Integer keywordId) {
        return keyWordMapper.incCountKeyword(keywordId);
    }

    @Override
    public int incKeywordCountTimesByQuestionId(Integer questionId) {
        return this.keyWordMapper.incCountTimesByQuestionId(questionId);
    }

    @Override
    public int incQuestionCountTimesByKeywordId(Integer keywordId) {
        return this.keyWordMapper.incQuestionCountTimesByKeywordId(keywordId);
    }

    @Override
    public long countKeyword() {
        return this.keyWordMapper.count();
    }

    @Override
    public List<KeyWord> findKeyWordList() {
        return this.keyWordMapper.list();
    }

    @Override
    public Set<Integer> findQuestionId(String keyword) {
        return this.keyWordMapper.selectQuestionIdByKeyword(keyword);
    }

    @Override
    public Set<Integer> findQuestionId(Set<String> keyWord) {
        return null;
    }

    @Override
    public Set<KeyWord> findKeywords(Set<String> keyword) {
        return null;
    }

    @Override
    public List<Question> findQuestionByKeyWords(Set<Integer> keyWordIds) {
        return this.keyWordMapper.selectQuestionByKeywordIds(keyWordIds);
    }
}
