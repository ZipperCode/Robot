package org.chat.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.chat.bean.Result;
import org.chat.bean.ResultCode;
import org.chat.bean.vo.Common;
import org.chat.bean.vo.Question;
import org.chat.service.ICommonService;
import org.chat.service.IKeyWordService;
import org.chat.utils.nlpir.Nlpir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zzp
 * @date 2020/2/26
 */
@RestController
public class SubmitController {

    @Autowired
    private IKeyWordService keyWordService;
    @Autowired
    private ICommonService commonService;

    @Autowired
    private Nlpir nlpir;

    // 方案一：问题查找，去常用表中查询  often表（常用表修改为视图）
    // 常用表中存在相同数据，直接返回给用户，often表数据使用量加1
    // 不存在数据，解析关键词，查找关键词表 keyword表
    // 获取关键词表的id， 查询关键词问题对应的表 question表
    // 取出与关键词匹配的问题数据
    // 如果没有数据，表示问题解答不了，
    // 再更具当前问题查询未解答问题表，
    // 若匹配，说明当前问题已经存在在未解答问题表中了，问题表中当前问题计数+1，
    // 将问题加入未解答问题表 unanswered
    // 得到问题后将用户问题与数据库问题进行相似度匹配
    // 每个问题得到的相似度进行排序，取相似度最高的问题取出，并判断相似度是否大于 0.5
    // 如果小于0.5，则将问题加入未解答问题表
    // 如果大于0.5，则即返回问题bean

    // 方案二：题查找，去常用表中查询  often表（常用表修改为视图）
    // 常用表中存在相同数据，直接返回给用户，often表数据使用量加1
    // 不存在数据，解析关键词，查找关键词表 keyword表，
    // 根据关键分析出问题方向，根据方向查找对应的表
    @GetMapping("/submit")
    @ResponseBody
    public Result submit(@NotNull(message = "我还没有收到问题呢!") String question){

        String keyWords = nlpir.getKeyWords(question, 10, false);
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
