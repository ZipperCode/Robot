package org.chat.service.impl;

import org.chat.bean.vo.Question;
import org.chat.dao.QuestionMapper;
import org.chat.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public int incQuestionCountTimes(Integer questionId) {
        return questionMapper.incCountTimes(questionId);
    }

    @Override
    public List<Question> findWithQuestion(Set<Integer> questionIds) {
        return null;
    }
}
