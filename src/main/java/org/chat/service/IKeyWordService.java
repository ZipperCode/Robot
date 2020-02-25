package org.chat.service;

import org.chat.vo.KeyWord;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
