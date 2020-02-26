package org.chat.bean.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 关键词实体，用于定位问题表和答案表
 * @author zzp
 * @date 2020/2/25
 */
@Data
public class KeyWord {
    /**
     * id
     */
    @Getter @Setter
    private Integer id;
    /**
     * 关键字
     */
    @Getter @Setter
    private String keyword;
    /**
     * 词性
     */
    @Getter @Setter
    private String nominal;
    /**
     * 每个词的权重
     */
    @Getter @Setter
    private String wordWeight;
    /**
     * 关键字在系统中的的所有问题出现的次数
     */
    @Getter @Setter
    private Integer wordTimes;
    /**
     * 关键词是否禁用 0表示禁用 1表示使用
     */
    @Getter @Setter
    private String ban;
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

}
