package org.chat.bean.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author zzp
 * @date 2020/2/25
 */
@Data
public class Question {
    /**
     * id
     */
    @Getter @Setter
    private Integer id;
    /**
     * 问题
     */
    @Getter @Setter
    private String question;
    /**
     * 分词列表 词/词性/词频#词/词性/词频
     */
    @Getter @Setter
    private String split;

    /**
     * 每个词的权重
     */
    @Getter @Setter
    private String wordsWeight;
    /**
     * 累计提问次数
     */
    @Getter @Setter
    private Integer countTimes;
    /**
     * 创建时间
     */
    @Getter @Setter
    private Date createTime;
    /**
     * 修改时间
     */
    @Getter @Setter
    private Date updateTime;

    /**
     *  关键词 关联的关键词表
     */
    @Getter @Setter
    private KeyWord keyword;
}
