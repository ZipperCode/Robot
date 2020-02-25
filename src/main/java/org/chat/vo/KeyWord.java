package org.chat.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
    private Integer wordTime;
    /**
     * 关键字词频
     */
    @Getter @Setter
    private Double wordFrequency;
    /**
     * tf 值 词频 该词条在文档中出现的频率
     */
    @Getter @Setter
    private Double tf;
    /**
     * idf 逆向文件频率
     */
    @Getter @Setter
    private Double idf;
    /**
     *
     */
    @Getter @Setter
    private Double ifIdf;
}
