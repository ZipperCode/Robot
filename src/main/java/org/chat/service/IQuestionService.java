package org.chat.service;

import org.chat.bean.vo.Question;

import java.util.List;
import java.util.Set;

public interface IQuestionService {

    int incQuestionCountTimes(Integer questionId);

    List<Question> findWithQuestion(Set<Integer> questionIds);
}
