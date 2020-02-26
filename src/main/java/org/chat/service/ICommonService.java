package org.chat.service;

import org.chat.bean.vo.Common;
import org.chat.dao.CommonMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ICommonService {

    int add(Common common);

    int update(Common common);

    /**
     * 根据Id查询问题
     * @param id CommonId
     * @return
     */
    Common findById(Integer id);

    /**
     * 直接查找问题
     * @param question 问题
     * @return 问题数据
     */
    Common findByQuestion(String question);

    /**
     * 根据关键词查询
     * @param keyword 关键词
     * @return 匹配结果
     */
    List<Common> findByKeyword(String keyword);

    /**
     * 根据多个关键词进行匹配
     * @param keywords 关键词集合
     * @return 匹配结果
     */
    List<Common> findByKeywords(Set<String> keywords);
    /**
     * 更新某个问题的使用值
     * @param commonId id
     * @return 成功1 失败0
     */
    int incCountTimes(String commonId);


}
