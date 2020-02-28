package org.chat.service.impl;

import org.chat.bean.vo.Common;
import org.chat.dao.CommonMapper;
import org.chat.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CommonServiceImpl implements ICommonService {

    @Autowired
    private CommonMapper commonMapper;

    @Override
    public int add(Common common) {
        return this.commonMapper.insert(common);
    }

    @Override
    public int update(Common common) {
        return this.commonMapper.update(common);
    }

    @Override
    public Common findById(Integer id) {
        return this.commonMapper.findById(id);
    }

    @Override
    public Common findByQuestionOne(String question) {
        return this.commonMapper.findByKeywordOne(question);
    }

    @Override
    public List<Common> findByQuestion(String question) {
        return this.commonMapper.selectByQuestion(question);
    }

    @Override
    public List<Common> findByKeyword(String keyword) {
        return this.commonMapper.selectByKeyword(keyword);
    }



//    @Override
//    public List<Common> findByKeywords(Set<String> keywords) {
//        return null;
//    }

    @Override
    public int incCountTimes(Integer commonId) {
        return this.commonMapper.incCountTimes(commonId);
    }

    @Override
    public long count() {
        return this.commonMapper.count();
    }
}
