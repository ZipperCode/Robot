package org.chat.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 问题检索服务
 */
@Service
public interface IQuestionRetrievalService {

    /**
     * 比较两个字符串的相似度
     * @param qSrc 源字符串
     * @param qDest 目标字符串
     * @return
     */
    Double compareSimilar(String qSrc, String qDest);

    /**
     * 两个句子分词，根据统计词频计算相似度
     * @param mapSrc 源句字词频
     * @param mapDest 目标句字词频
     * @return 相似度
     */
    Double compareSimilar(Map<String,Double> mapSrc,Map<String,Double> mapDest);


}