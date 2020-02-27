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
        return 0;
    }

    @Override
    public int update(Common common) {
        return 0;
    }

    @Override
    public Common findById(Integer id) {
        return null;
    }

    @Override
    public Common findByQuestion(String question) {
        return null;
    }

    @Override
    public List<Common> findByKeyword(String keyword) {
        return this.commonMapper.findByKeyword(keyword);
    }

    @Override
    public List<Common> findByKeywords(Set<String> keywords) {
        return null;
    }

    @Override
    public int incCountTimes(Integer commonId) {
        return 0;
    }
}
