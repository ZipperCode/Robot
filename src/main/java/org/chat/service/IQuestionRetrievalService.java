package org.chat.service;

import org.apache.ibatis.javassist.compiler.ast.Keyword;
import org.chat.bean.vo.Common;
import org.chat.bean.vo.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 问题检索服务
 */
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

    String split(String question);

    /**
     * 常用表查找查找
     * @param question
     * @return
     */
    Common findWithCommon(String question);

    /**
     * 问题表查找
     * @param question
     * @return
     */
    Question findWithQuestion(String question);

    /**
     *
     * @param question
     * @return
     */
    List<Keyword> findMatchKeywords(String question);


}
