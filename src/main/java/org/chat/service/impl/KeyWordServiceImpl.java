package org.chat.service.impl;

import org.chat.service.IKeyWordService;
import org.chat.bean.vo.KeyWord;
import org.chat.bean.vo.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author zzp
 * @date 2020/2/26
 */
@Service
public class KeyWordServiceImpl implements IKeyWordService {
    @Override
    public int add(KeyWord keyWord) {
        return 0;
    }

    @Override
    public int update(KeyWord keyWord) {
        return 0;
    }

    @Override
    public List<KeyWord> keyWord() {
        return null;
    }

    @Override
    public Set<Integer> findKeyWord(Set<String> keyWord) {
        return null;
    }

    @Override
    public List<Question> findQuestionByKeyWords(Set<Integer> keyWordIds) {
        return null;
    }
}
