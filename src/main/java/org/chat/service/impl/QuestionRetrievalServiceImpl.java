package org.chat.service.impl;

import lombok.extern.log4j.Log4j2;
import org.chat.annotation.Log;
import org.chat.bean.vo.Common;
import org.chat.service.ICommonService;
import org.chat.service.IQuestionRetrievalService;
import org.chat.utils.Similarity;
import org.chat.utils.StringUtils;
import org.chat.utils.nlpir.Nlpir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Log4j2
public class QuestionRetrievalServiceImpl implements IQuestionRetrievalService {
    @Autowired
    private ICommonService commonService;
    @Autowired
    private Nlpir nlpir;

    @Override @Log
    public Double compareSimilar(String qSrc, String qDest) {
        return null;
    }

    @Override @Log
    public Double compareSimilar(Map<String, Double> mapSrc, Map<String, Double> mapDest) {
        return Similarity.vsm(mapSrc, mapDest);
    }

    /**
     * 普通问题查找
     * @param question
     * @return
     */
    @Override @Log
    public Common findWithCommon(String question) {
        Common commonQuestion = this.commonService.findByQuestion(question);
        log.info(commonQuestion);
        if(commonQuestion != null){
            return commonQuestion;
        }else{
            // 提取关键词字符串
            String keyWords = nlpir.getKeyWords(question, 2, false);
            // 将关键词转化为 set集合
            Set<String> keywordSet = StringUtils.splitKeyword(keyWords);
            List<Common> commonList = this.commonService.findByKeywords(keywordSet);
            Common result = commonList.stream().collect(
                    Collectors.toMap(x -> x, x -> compareSimilar(x.getQuestion(), question)))
                    .entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(null);
            System.out.println(result);
            return result;
        }
    }
}
