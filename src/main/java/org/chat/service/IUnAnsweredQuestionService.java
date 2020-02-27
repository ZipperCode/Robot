package org.chat.service;

import org.chat.bean.vo.UnAnsweredQuestion;

public interface IUnAnsweredQuestionService {

    /**
     * 往未解答问题表添加一条记录
     * @param question
     * @return
     */
    int add(UnAnsweredQuestion question);

    /**
     * 更新为解答问题表
     * @param question
     * @return
     */
    int update(UnAnsweredQuestion question);

    /**
     * 删除为解答问题表记录
     * @param unAnsweredQuestionId
     * @return
     */
    int delete(Integer unAnsweredQuestionId);

    /**
     * 累加未解答问题表的计数值
     * @param unAnsweredQuestionId
     * @return
     */
    int incUnAnsweredQuestion(Integer unAnsweredQuestionId);
}
