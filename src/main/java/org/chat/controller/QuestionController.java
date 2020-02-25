package org.chat.controller;

import org.chat.bean.Result;
import org.chat.bean.ResultCode;
import org.chat.service.IKeyWordService;
import org.chat.utils.Similarity;
import org.chat.utils.nlpir.NLPIR;
import org.chat.utils.nlpir.NlpirLib;
import org.chat.vo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class QuestionController {

    @Autowired
    private IKeyWordService keyWordService;

    public Result submit(String question){
        String keyWords = NLPIR.getKeyWords(question, 10, false);
        Set<String> keyWordSet = Arrays.stream(keyWords.split("#")).collect(Collectors.toSet());
        // 根据关键字信息查询数据库是否有对应的关键字
        Set<Integer> keyWordIds = keyWordService.findKeyWord(keyWordSet);
        // 根据关键词查找问题
        List<Question> questionByKeyWords = keyWordService.findQuestionByKeyWords(keyWordIds);
        // 将问题与关键词查询的问题进行相似度比较
        Question resultQuestion = null;
        for(Question q : questionByKeyWords){

        }
        // 封装最符合要求的结果
        return new Result(ResultCode.SUCCESS,new Question());

    }
}
