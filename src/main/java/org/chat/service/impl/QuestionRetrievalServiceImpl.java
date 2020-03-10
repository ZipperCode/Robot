package org.chat.service.impl;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.javassist.compiler.ast.Keyword;
import org.chat.annotation.Log;
import org.chat.bean.vo.Common;
import org.chat.bean.vo.KeyWord;
import org.chat.bean.vo.Question;
import org.chat.service.ICommonService;
import org.chat.service.IKeyWordService;
import org.chat.service.IQuestionRetrievalService;
import org.chat.service.IQuestionService;
import org.chat.utils.Similarity;
import org.chat.utils.StringUtils;
import org.chat.utils.nlpir.Nlpir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Log4j2
@Service
public class QuestionRetrievalServiceImpl implements IQuestionRetrievalService {

    @Autowired
    private ICommonService commonService;
    @Autowired
    private Nlpir nlpir;
    @Autowired
    private IKeyWordService keyWordService;
    @Autowired
    private IQuestionService questionService;

    @Override @Log
    public Double compareSimilar(String qSrc, String qDest) {
        return null;
    }

    @Override @Log
    public Double compareSimilar(Map<String, Double> mapSrc, Map<String, Double> mapDest) {
        return Similarity.vsm(mapSrc, mapDest);
    }

    @Override @Log
    public String split(String question) {
        String s = this.nlpir.wordFreqStat(question);
        return StringUtils.format(s);
    }

    /**
     * 普通问题查找
     * @param question
     * @return
     */
    @Override @Log
    public Common findWithCommon(String question) {
        Common commonQuestion = this.commonService.findByQuestionOne(question);
        log.info(commonQuestion);
        if(commonQuestion != null){
            return commonQuestion;
        }else{
            // 提取关键词字符串
            String keyWords = nlpir.getKeyWords(question, 2, false);
            // 将关键词转化为 set集合
            Set<String> keywordSet = StringUtils.splitKeyword(keyWords);
            List<Common> commonQuestionList = new ArrayList<>();
            for(String keyword : keywordSet){
                commonQuestionList.addAll(this.commonService.findByKeyword(keyword));
            }
            // 查找关键词相关的问题
            // List<Common> commonList = this.commonService.findByKeywords(keywordSet);

            Common result = commonQuestionList.stream().collect(
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

    @Override
    public Question findWithQuestion(String question) {
        String[] keyWords = this.nlpir.getKeyWords(question, 10, false).split("#");

        Set<Integer> questionIds = this.keyWordService.findQuestionId(new HashSet<>(Arrays.asList(keyWords)));
//        Set<KeyWord> keywords = this.keyWordService.findKeywords(new HashSet<>(Arrays.asList(keyWords)));
        List<Question> questions = this.questionService.findWithQuestion(questionIds);
        Question matchQuestion = questions.stream().collect(
                Collectors.toMap(x -> x, x -> compareSimilar(x.getQuestion(), question)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        return matchQuestion;
    }

    @Override
    public List<Keyword> findMatchKeywords(String question) {
        String[] keyWords = this.nlpir.getKeyWords(question, 10, false).split("#");
        return null;
    }


}
