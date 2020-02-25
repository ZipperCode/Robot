package org.chat.vo;

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
    private String keyWord;
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

    @Getter @Setter
    private Date createTime;

    @Getter @Setter
    private Date updateTime;


    /****************** 中间表 **********************/

    private Integer questionId;


}
