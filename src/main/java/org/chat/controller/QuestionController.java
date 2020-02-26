package org.chat.controller;

import org.chat.bean.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
public class QuestionController {



    /**
     * 解答未解答的问题
     * @param unQuestionId
     * @param answer
     * @return
     */
    @GetMapping("/answer")
    @ResponseBody
    public Result answer(@NotNull(message = "[\"/answer\"] unQuestionId 不能为空") Integer unQuestionId,
                         @NotNull(message = "[\"/answer\"] answer 不能为空") String answer){
        // 解答未解答问题：
        // 取出未解答问题关键词，匹配未关键词表进行关键词计数
        // 将未解答问题，和所得答案添加到问题表中，
        // 删除当前未解答问题数据，
        return new Result();
    }

}
